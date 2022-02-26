<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<style>
.body-area1{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
}</style>
<%@include file="akalinks.jsp"%>
</head>
<body class="body-area1">
<div style=" position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
    ;">
    
<a href="<c:url value='/customerhome' />" class="btn btn-primary">Back</a>
</div><br><br>
	<div class="container" style="padding: 20px">
		<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="panel-heading"  style="text-align:center"><h3>Customer Profile</h3></div>
			<div class="panel-body">
			<table class="table table-bordered">
			<tr><td><h4>${promptContent}</h4></td></tr>
			<tr>
				<td><strong>Account No:</strong> ${customer.accountNo}</td>
				<td><strong>Name:</strong>${customer.customerName}</td>
				</tr>
				<tr>
				<td><strong>Mobile No:</strong>${customer.mobNo}</td>
				<td><strong>Gender:</strong>${customer.gender}</td>
				</tr>
				<tr>
				<td><strong>Aadhar No:</strong>${customer.aadharNo}</td>
				<td><strong>PAN No:</strong>${customer.panNo}</td>
				</tr>
				<tr>
				<td><strong>Account Type:</strong>${customer.account.accountType}</td>
				<td><strong>Email Id:</strong>${customer.email}</td>
				</tr>
				<tr>
				<td><strong>Date Of Birth:</strong>${dateOfBirth}</td>
				</tr>
				<tr>
				<td>
				<h4>Address:</h4>
				<br> <strong>House No:</strong>${customer.custHouseNoName}<br>
				<strong>Street Name:</strong>${customer.custStreetName}<br> 
				<strong>Landmark:</strong>${customer.custLandmark}<br>
				<strong>City:</strong>${customer.city}<br>
				 <strong>State:</strong>${customer.state}<br>
				<strong>Country:</strong>${customer.custCountry}<br> 
				<strong>Pin-code:</strong>${customer.custPincode}<br>
				</td>
				<td>
				<%-- <img alt="no image" src="<c:url value="/WEB-INF/images/"/>${image1}"> --%>
				<img alt="no image" width="100" src="${pageContext.request.contextPath}/images/rohit.jpg"/>
				</td>
				<td><c:url value="/WebContent/WEB-INF/images/"/>${image1}</td>
				</tr>
				<tr>
				<%-- <td>${pageContext.request.contextPath}</td> --%>
				<td><strong>Branch Name:</strong>${customer.custBranch}</td>
				<td><strong>IFSC:</strong>${customer.account.IFSC}</td>
				</tr>
				</table>
				<a href="<c:url value='/editProfilePage' />" class="btn btn-primary">Edit Profile</a>
				<a href="customerhome" class="btn btn-primary">Cancel</a>
			</div>
		</div>
	</div>
	<%@include file="akascripts.jsp"%>
</body>
</html>