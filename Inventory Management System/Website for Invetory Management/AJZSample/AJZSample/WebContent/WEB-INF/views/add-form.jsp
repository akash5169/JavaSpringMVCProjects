
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Add Product Page</title>
<%@include file="resolink.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
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
  background-image: url("${pageContext.request.contextPath}/webjars/images/loginBG.jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

</style>
</head>
<body class="bg">
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Product</div>
				</div>
				<div class="panel-body">
				<c:url var="myaction" value="/saveProduct"></c:url>
					<form:form action="${myaction}" method="post" modelAttribute="product" cssClass="form-horizontal">
	
						<!-- need to associate this data with product id -->
						<form:hidden path="product_id" />
						
						<div class="form-group">
							<label for="product_cate" class="col-md-3 control-label">Product
								ID</label>
							<div class="col-md-9">
								<label for="product_id" class="col-md-3 control-label">${product.product_id}</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="product_cate" class="col-md-3 control-label">Product
								Category</label>
							<div class="col-md-9">
								<form:input placeholder="eg. Meat" required="required" path="product_cate" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="product_type" class="col-md-3 control-label">Product
								Type</label>
							<div class="col-md-9">
								<form:input placeholder="eg. Chicken Thighs" required="required" path="product_type" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="borv" class="col-md-3 control-label">Brand/Variety</label>
							<div class="col-md-9">
								<form:input placeholder="eg. Skinless" required="required" path="borv" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="place" class="col-md-3 control-label">Place</label>
							<div class="col-md-9">
								<form:input placeholder="eg. Freezer2"  required="required" path="place" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="weight" class="col-md-3 control-label">Weight</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 1.0" required="required" path="weight" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="price" class="col-md-3 control-label">Prize</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 5.0" required="required" path="price" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="expiration_date" class="col-md-3 control-label">Expiration Date:(yyyy-MM-dd)</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 2021-06-12" type="text" id="expiration_date" path="expiration_date" required="required" autocomplete="off" /> 
							</div>
						</div>
						
						<div class="form-group">
							<label for="manufacture_date" class="col-md-3 control-label">Manufacture Date:(yyyy-MM-dd)</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 2021-06-12" type="text" id="manufacture_date" path="manufacture_date" required="required" autocomplete="off" /> 
							</div>
						</div>
						
						<div class="form-group">
							<label for="weight_unit" class="col-md-3 control-label">Weight Unit</label>
							<div class="col-md-9">
								<form:input placeholder="eg. lbs/oz" required="required" path="weight_unit" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="tax" class="col-md-3 control-label">Tax</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 0.6" required="required" path="tax" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="discount" class="col-md-3 control-label">Discount in %</label>
							<div class="col-md-9">
								<form:input placeholder="eg. 2.5" required="required" path="discount" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="supplier_id" class="col-md-3 control-label">Supplier ID</label>
							<div class="col-md-9">
								<form:input placeholder="eg. Meat_S1" required="required" path="supplier_id" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
						
						<c:url var="cancelaction" value="/inventory"></c:url>
                            <a href="${cancelaction}" class="btn btn-danger col-md-offset-3 col-md-2" >CANCEL</a>
						 
							<div class="col-md-7">
								<input type="submit" value="Add" class="btn btn-success text-uppercase" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>


<%@include file="resoscripts.jsp"%>
</body>
</html>