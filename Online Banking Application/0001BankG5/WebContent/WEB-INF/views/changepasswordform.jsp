<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Form</title>
<style>
.body-area3{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
    }</style>
<%@include file="akalinks.jsp"%>
<script >

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

window.onload = function () { history.forward(); };

</script>
</head>
<body class="body-area3">
<div style=" position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
    ;">
    
<a href="<c:url value='/customerhome' />" class="btn btn-primary">Back</a>
</div><br><br><br>

<div class="panel panel-default col-md-6 col-md-offset-3">
		<div class="panel-heading">Change Password Form</div>
		<div class="panel-body">
            <c:url var="myaction" value="/tryChangePassword"></c:url>
			<form:form action="${myaction}" method="get"
				modelAttribute="login">
				<table class="table ">
					<tr>
						<td><form:label path="password" >
								<spring:message text="Password:" />
							</form:label></td>
						<td><form:input path="password" required="required" id="pwd"/> <form:errors
								path="password" cssClass="errors">
							</form:errors></td>
					</tr>
					<tr>
					<td>
					<form:label path="" >
								<spring:message text="Confirm Password:" />
							</form:label></td>
						<td><form:input path="" required="required" id="cnf"/></td>
					</tr>
					<tr>
					<td><input type="submit" value="Change Password" class="btn btn-success" onclick="return check()"/></td>
					<td>
					<form:hidden path="accountNo" value="${accountNo}" />
					<form:hidden path="userId" value="${userId}" />				
					</table>
					</form:form>
					</div>
					</div>
	<%@include file="akascripts.jsp"%>
</body>
</html>