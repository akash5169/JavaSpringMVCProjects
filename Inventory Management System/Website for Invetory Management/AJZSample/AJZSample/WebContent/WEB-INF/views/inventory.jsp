<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ajz.model.Product"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Inventory Page</title>
<%@include file="resolink.jsp"%>
<script>
	window.onload = function() {
		history.forward();
	};
</script>

<style>

body, html {
  height: 100%;
}

.bg {
  /* The image used */
  background-image: url("${pageContext.request.contextPath}/webjars/images/invBG.jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.table-striped tbody tr:nth-child(odd) td {
  background-color: #dce9ec;
}

.table-striped tbody tr:nth-child(even) td {
  background-color: #c5dfe6;
}

.table-striped tbody tr.highlight td {
  background-color: #F2F5A9;
}

th {
  background-color: #337ab7;
}

.arrange-horizontally > * {
    display: inline-block;
    text-align: center;
}

/* Class to arrange divs verically */
.arrange-vertically > * {
    display: block;
}

</style>

</head>
<body class="bg">

<div class="form-group arrange-horizontally">
<div class="col-md-offset-5">
<h1>INVENTORY</h1>
</div>
<c:url var="addaction" value="/logout"></c:url>
 <a href="${addaction}" class="btn btn-danger	col-md-offset-3" >LOGOUT</a>
</div>

 <div class="form-group col-md-offset-1">
 <c:url var="addaction" value="/addForm"></c:url>
 <a href="${addaction}" class="btn btn-success	col-md-2" >ADD PRODUCT</a>
 
 <div class="col-md-5">
     <form action="" method="get">
     <input type="text" name="search" autocomplete="off" class="form-control col-md-4 col-md-offset-2" placeholder="Search Here..">
     </form> 
 </div>
 </div>
 
 <br>
 <br>
 <br>

	<table class="table table-bordered table-striped" style="width: 85%; margin-left: auto; margin-right: auto;">

		<tr>
		<th width="60">Product Id</th>
		<th width="40">Product Category</th>
			<th width="80">Product Type</th>
			<th width="80">Brand/Variety</th>
			<th width="70">Place</th>
			<th width="60">Weight</th>
			<th width="60">Price</th>
			<th width="100">Expiration Date</th>
			<th width="80">ACTION</th>
		</tr>
		<%! 
		public static Boolean decider(Product product, String newValue)
		{
            if (newValue == null || newValue.equals("")) {
                return true;
            }
            System.out.println("I am searching for "+newValue);
            String lowerCaseFilter = newValue.toLowerCase();
            String sDate=lowerCaseFilter;

            char ch[]=sDate.toCharArray();
            Boolean flag=false;
            Boolean flag2=false;
            if(ch [0]=='>' || ch [0]=='<')
            {
                System.out.println(ch[0]);
                if(ch.length>10 && sDate.contains("-"))
                {flag=true;}
                else
                {
                    flag2=true;
                }
            }
            String sDate2="";
            for(int i=1;i<ch.length;i++)
            {
                sDate2=sDate2+ch[i];
            }
            SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
            Date d=null;
            try {
                d=sf.parse(sDate2);
                System.out.println(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //filters according to various columns
            if(flag && ch[0]=='<')
            {
                Boolean b=product.getExpiration_date().before(d);
                return b;
            }
            else if(flag && ch[0]=='>')
            {
                Boolean b=product.getExpiration_date().after(d);
                return b;
            }
         
            else if (product.getProduct_cate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                return true;
            } else if (product.getProduct_type().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true;
            }else if (product.getPlace().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true;
            }
            else if (product.getBorv().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                return true;
            }
            else if(product.getSupplier_id().toLowerCase().indexOf(lowerCaseFilter)!=-1)
            {
                return true;
            }else if (String.valueOf(product.getProduct_id()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                return true;
            }
            else if(flag2 && ch[0]=='>')
            {
                Boolean b=false;
                try{
                    Float dis=Float.parseFloat(sDate2);
                    b=product.getDiscount()>dis;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                return b;
            }
            else if(flag2 && ch[0]=='<')
            {
                Boolean b=false;
                try{
                    Float dis=Float.parseFloat(sDate2);
                    b=product.getDiscount()<dis;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                return b;
            }
            else
                return false; // Does not match.
		}
		%>
			
		
		<%
			List<Product> plist=new ArrayList<Product>();
			List<Product> proList=(List<Product>)request.getAttribute("proList");
			System.out.print("I am printing from jsp page");
			System.out.print(proList);
			for(Product p:proList)
			{
				System.out.println("I returned "+decider(p,request.getParameter("search")));
				if(decider(p,request.getParameter("search")))
				{
					plist.add(p);
				}
		    }
			System.out.print(plist);
			request.setAttribute("plist", plist);

		%>
		<c:forEach items="${plist}" var="product">
			<tr>
			<td>${product.product_id}</td>
			<td>${product.product_cate}</td>
			<td>${product.product_type }</td>
			<td>${product.borv}</td>
			<td>${product.place}</td>
			<td>${product.weight}</td>
			<td>${product.price}</td>	
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${product.expiration_date}"/></td>
			<td>
                       <!-- construct an "update" link with product id -->
							<c:url var="updateLink" value="/updateForm">
								<c:param name="productId" value="${product.product_id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/delete">
								<c:param name="productId" value="${product.product_id}" />
							</c:url>
							
							<!-- display the update link -->
							 <a href="${updateLink}" class="btn btn-primary btn-xs" >Update</a>
						     <a href="${deleteLink}" class="btn btn-danger btn-xs" onclick="if (!(confirm('Are you sure you want to delete product with ID ${product.product_id} ?'))) return false">Delete</a>
								
             </td>	
		    </tr>
		    </c:forEach>	
	
	</table>
	<%@include file="resoscripts.jsp"%>
</body>
</html>