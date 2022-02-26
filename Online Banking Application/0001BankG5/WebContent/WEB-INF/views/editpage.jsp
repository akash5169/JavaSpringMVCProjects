<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="akalinks.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<style>
.body-area2{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
}</style>
<script>
    window.onload = function () { history.forward(); };
</script>
</head>
<body class="body-area2">
<div class="container" style="padding: 20px">
		<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="panel-heading" style="text-align:center"><h3>Edit Profile</h3></div>
			<div class="panel-body">
			<table class="table table-bordered">
	<c:url var="myaction" value="/trySaveAfterEdit"></c:url>
	<form:form action="${myaction}" method="get" modelAttribute="customer">
		<table class="table table-bordered">
			<tr>
			    <td><form:label path="customerName"> <spring:message text="Name" /></form:label>
				<td><form:input path="customerName" />
				<form:errors path="customerName" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
			<td><form:label path="mobNo"> <spring:message text="Mobile Number:" /></form:label>
				<td><form:input path="mobNo" />
				<form:errors path="mobNo" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="email"><spring:message text="Email:" /></form:label>
				<td><form:input path="email" />
				<form:errors path="email" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
			<td><h4>Address</h4></td>
			</tr>
			<tr>
				<td><form:label path="custHouseNoName"><spring:message text="House No:" /></form:label>
				<td><form:input path="custHouseNoName" />
				<form:errors path="custHouseNoName" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				
				<td><form:label path="custStreetName"><spring:message text="Street Name:" /></form:label>
				<td><form:input path="custStreetName" />
				<form:errors path="custStreetName" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				
				<td><form:label path="custLandmark"><spring:message text="LandMark:" /></form:label>
				<td><form:input path="custLandmark" />
				<form:errors path="custLandmark" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				
                <td><form:label path="city"><spring:message text="City:" /></form:label>
				<td><form:input path="city" />
				<form:errors path="city" cssClass="errors"></form:errors></td>			</tr>
			<tr>
			
				<td><form:label path="state"><spring:message text="State:" /></form:label>
				<td><form:input path="state" />
				<form:errors path="state" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
			
				<td><form:label path="custCountry"><spring:message text="Country:" /></form:label>
				<td><form:input path="custCountry" />
				<form:errors path="custCountry" cssClass="errors"></form:errors></td>
			</tr>
			<tr>
				
				<td><form:label path="custPincode"><spring:message text="Pincode:" /></form:label>
				<td><form:input path="custPincode" />
				<form:errors path="custPincode" cssClass="errors"></form:errors></td>
			</tr>
			
			<tr>
				<td align="center"><input type="submit" value="Save" class="btn btn-success"></td>
				<td><a href="<c:url value='/customerhome' />" class="btn btn-primary">Cancel</a></td>
			</tr>

		</table>
		<form:hidden path="gender" value="${customer.gender}" />
		<form:hidden path="account.accountBalance" value="${account.accountBalance}" />
		<form:hidden path="account.accountType" value="${account.accountType}" />
		<form:hidden path="account.IFSC" value="${account.IFSC}" />
		<form:hidden path="accountNo" value="${accountNo}" />
		<form:hidden path="custBranch" value="${custBranch}" />
		<form:hidden path="login.accountNo" value="${login.accountNo}" />
		<form:hidden path="aadharNo" value="${aadharNo}" />
		<form:hidden path="panNo" value="${panNo}" />
		<form:hidden path="account.accountNo" value="${account.accountNo}" />
		<form:hidden path="login.userId" value="${login.userId}" />
		<form:hidden path="login.password" value="${login.password}" />
		<form:hidden path="dob" value="${dob}" />
		
	</form:form>
	</table>
	</div>
	</div>
	</div>
<%@include file="akascripts.jsp"%>
</body>
</html>