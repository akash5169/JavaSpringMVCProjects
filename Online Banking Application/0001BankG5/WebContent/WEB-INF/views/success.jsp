<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password Success</title>
<script>
   window.onload = function () { history.forward(); };
</script>
<%@include file="profilelink.jsp"%>
<%@include file="links.jsp"%>
</head>
<body>
<div class="main">
		<h1></h1>
		<div id="navigation" style="display: none;" class="w3_agile"></div>
		<div id="wrapper" class="w3ls_wrapper w3layouts_wrapper">
			<div id="steps" style="margin: 0 auto;" class="agileits w3_steps"></div>
			<h1><strong><font color="#903e44" style="font-family: -webkit-pictograph">You are successfully Registered!</font></strong></h1>
			<div class="abt-agile">

				<div class="abt-agile-centre">
					
					</div>
					<br>
					<div>
					<table class="table table-bordered" style="background-color:white">
						<tr>
							<td><strong style="color: black;     font-weight: bolder;">Account No.:</strong></td>
							<td style="color: black;     font-weight: bolder;">${customer.accountNo}</td>
						</tr>
					
						<tr>
							<td><strong style="color: black;     font-weight: bolder;">User Id:</strong></td>
							<td style="color: black;     font-weight: bolder;">${customer.login.userId}</td>
						</tr>
						
						<tr>
							<td><strong style="color: black;     font-weight: bolder;">Password:</strong></td>
							<td style="color: black;     font-weight: bolder;">${customer.login.password}</td>
						</tr>
				
					</table>
							<a href="<c:url value='/'/>" class="primary-btn text-uppercase">OK</a>
					</div>
					</div>
</div>
</div>

<%@include file="akascripts.jsp"%>
<%@include file="scripts.jsp"%>
</body>
</html>