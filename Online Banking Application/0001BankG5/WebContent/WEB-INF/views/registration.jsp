 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="akalinks.jsp"%>
<%@include file="links.jsp"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="keywords" content="">
<meta charset="UTF-8">
<title>Registration Page</title>


<style type="text/css">

.header-w3ls {
    letter-spacing: 6px;
    color: brown;
    text-color:brown;
    font-family: monospace;
    font-weight: 600;
}
.errors {
	color: red;
	font-style: italic;
	font-weight: bold;
}
.body-area{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
}
.ui-datepicker .ui-datepicker-title select {
    color:#f00;
}
.heading{
 text-align: center;
 margin-top:40px;
 }
 .ui-datepicker .ui-datepicker-title select {
    color:#f00;
}

</style>
<script >
 
window.onload = function () { history.forward(); };

function check(){
var a= document.getElementById("cnf").value;
var b=document.getElementById("pwd").value;
if(a!=b)
	{
	alert("passwords do not match!!")
	return false;
	}
else{
return true;
}
}

function getPath(a)
{
   	
	}
</script>

<link
href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
rel="stylesheet"/>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

</head>
<body class="body-area">
	
<!-- <div class="heading"><h1>Registration Form</h1></div> -->
	
	<!-- <div class="overlay overlay-bg"></div> -->
	<div class="container" style="padding: 20px ;margin-top:50px">
		<div class="row fullscreen align-items-center justify-content-between" >
		
		
	<div class="panel panel-default col-md-6 col-md-offset-3" style="margin: 300px 0px 0px 0px;">
	
			<div class="panel-heading" style="text-align:center"><h3>Registration Form</h3></div>
				<div class="panel-body">
            <c:url var="myaction" value="/doRegister"></c:url>
			<form:form action="${myaction}" method="get"
				modelAttribute="customer" >
				<table class="table ">
					<tr>
					
						<td><form:label path="customerName">
								<spring:message text="Name" />
							</form:label></td>
						<td><form:input path="customerName" /> <form:errors
								path="customerName" cssClass="errors"></form:errors></td>
					</tr>

					<tr>
						<td><form:label path="mobNo">
								<spring:message text="Phone No:" />
							</form:label></td>
						<td><form:input path="mobNo" /> <form:errors path="mobNo"
								cssClass="errors"></form:errors></td>
					</tr>
					
					<tr>
					<td><form:label path="gender"><spring:message text="Gender:" />
							</form:label></td>
						<td><form:radiobutton path="gender" value="MALE" />MALE <form:radiobutton
								path="gender" value="FEMALE" />FEMALE</td>
						<td> <form:errors path="gender"
								cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
					<td><form:label path="account.accountType"><spring:message text="AccountType:" />
							</form:label></td>
						<td><form:radiobutton path="account.accountType" value="savings" />Savings
							<form:radiobutton path="account.accountType" value="current" />Current</td>
						<td><form:errors
								path="account.accountType" cssClass="errors">
							</form:errors></td>
					</tr>
					
				<%-- 	<tr>
						<td><form:label path="custImageFile">
								<spring:message text="Recent Photograph:" />
							</form:label></td>
						<td><form:input type="file" id="custImage" path="custImageFile" /> <form:errors path="custImageFile"
								cssClass="errors">
							</form:errors></td>
					</tr>
					
                    <tr>
						<td><form:label path="custSignFile">
								<spring:message text="Signature photocopy:" />
							</form:label></td>
						<td><form:input type="file" id="custSign"  path="custSignFile" /> <form:errors path="custSignFile"
								cssClass="errors">
							</form:errors></td>
					</tr>
                     --%>
                    <%--  <td><form:label path="customerImage">
								<spring:message text="Recent Photograph:" />
							</form:label></td>
						<td><form:input type="file" id="custImage" path="customerImage" /> <form:errors path="customerImage"
								cssClass="errors">
							</form:errors></td>
					</tr>
					
                    <tr>
						<td><form:label path="customerSignature">
								<spring:message text="Signature photocopy:" />
							</form:label></td>
						<td><form:input type="file" id="custSign"  path="customerSignature" /> <form:errors path="customerSignature"
								cssClass="errors">
							</form:errors></td> --%>
                    					
                   <tr>
						<td><form:label path="email">
								<spring:message text="Email:" />
							</form:label></td>
						<td><form:input path="email" /> <form:errors path="email"
								cssClass="errors">
							</form:errors></td>
					</tr>
                   
					<tr>
						<td><form:label path="dob">
								<spring:message text="Date of Birth:(mm-dd-yyyy)" />
							</form:label></td>
						<td>
						<form:input type="text" id="dob" path="dob" required="required" autocomplete="off" /> 
						<form:errors path="dob" cssClass="errors"></form:errors></td>
						<td><script type="text/javascript">
						$(function() {
							 var now=new Date();  
							 var limit=now.getFullYear();
						   $('input[id$=dob]').datepicker({dateFormat:'mm-dd-yy',
								showOtherMonths:true,
								selectOtherMonths:true,	
								changeMonth:true,
								changeYear:true,
							     yearRange:"-90:-18"
							});
							$('#dob').datepicker();
							$('#dob').datepicker("show");
						});
						</script></td>
					</tr>

					<tr>
						<td><form:label path="custHouseNoName">
								<spring:message text="House No.:" />
							</form:label></td>
						<td><form:input path="custHouseNoName" /> <form:errors
								path="custHouseNoName" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="custStreetName">
								<spring:message text="Street Name:" />
							</form:label></td>
						<td><form:input path="custStreetName" /> <form:errors
								path="custStreetName" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="custLandmark">
								<spring:message text="Landmark:" />
							</form:label></td>
						<td><form:input path="custLandmark" /> <form:errors
								path="custLandmark" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="city">
								<spring:message text="City:" />
							</form:label></td>
						<td><form:input path="city" /> <form:errors path="city"
								cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="state">
								<spring:message text="State:" />
							</form:label></td>
						<td><form:input path="state" /> <form:errors path="state"
								cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="custCountry">
								<spring:message text="Country:" />
							</form:label></td>
						<td><form:input path="custCountry" /> <form:errors
								path="custCountry" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="custPincode">
								<spring:message text="Pin-code:" />
							</form:label></td>
						<td><form:input path="custPincode" /> <form:errors
								path="custPincode" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="custBranch">
								<spring:message text="Branch:" />
							</form:label></td>
						<td><form:select path="custBranch" items="${branchNames}" required="required"/> <form:errors
								path="custBranch" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="aadharNo">
								<spring:message text="AadharNo.:" />
							</form:label></td>
						<td><form:input path="aadharNo" /> <form:errors
								path="aadharNo" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="panNo">
								<spring:message text="PanNo.:" />
							</form:label></td>
						<td><form:input path="panNo" /> <form:errors path="panNo"
								cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="login.userId">
								<spring:message text="Create New UserID:" />
							</form:label></td>
						<td><form:input path="login.userId"  required="required"/> <p style="color:red">${promptContent }</p><form:errors
								path="login.userId" cssClass="errors">
							</form:errors></td>
					</tr>

					<tr>
						<td><form:label path="login.password" >
								<spring:message text="Password:" />
							</form:label></td>
						<td><form:input type="password" path="login.password" required="required" id="pwd"/> <form:errors
								path="login.password" cssClass="errors">
							</form:errors></td>
					</tr>
					<tr>
					<td>
					<form:label path="" >
								<spring:message text="Confirm Password:" />
							</form:label></td>
						<td><form:input type="password" path="" required="required" id="cnf"/></td>
					</tr>
					<tr>
					<td><input type="submit" value="Register" class="btn btn-success" onclick="return check()"/></td>
					<td><a href="<c:url value='/' />" class="btn btn-primary">Cancel</a></td>
					</tr>

				</table>
				<form:hidden path="account.accountBalance" value="0.00" />				
				<form:hidden path="account.IFSC" value="abcd" />
				<form:hidden path="accountNo"  value="${accountNo}"/>
					<form:hidden path="login.accountNo" value="${login.accountNo}"/>
					<form:hidden path="account.accountNo" value="${account.accountNo}"/>
				<%-- 	<form:hidden path="customer.account" />
					<form:hidden path="customer.login" /> --%>
			</form:form>
        
		</div>
	</div>
	</div>
		</div>


	
	<%@include file="akascripts.jsp"%>
	<%@include file="scripts.jsp"%>
	
</body>
</html>

