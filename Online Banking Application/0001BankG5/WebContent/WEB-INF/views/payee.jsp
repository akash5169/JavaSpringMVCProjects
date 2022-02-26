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
<title>Payee Form</title>
<%@include file="akalinks.jsp"%>
<style type="text/css">
.body-area6{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
    }
/* .errors {
	color: red;
	font-style: italic;
	font-weight: bold;
} */
</style>
<script>window.onload = function () { history.forward(); };</script>
</head>
<body class="body-area6">
<div style=" position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
    ;">
    
<a href="<c:url value='/customerhome' />" class="btn btn-primary">Back</a>
</div>
<br><br><br><br>
	<div class="panel panel-default col-md-6 col-md-offset-3">
		<div class="panel-heading"><h3>Payee Form</h3></div>
		<div class="panel-body">
            <c:url var="myaction" value="/addPayee"></c:url>
			<form:form action="${myaction}" method="get"
				modelAttribute="payee">
				<table class="table ">
			
					<tr>
						<td><form:label path="payeeName">
								<spring:message text="Payee Name:" />
							</form:label></td>
						<td><form:input path="payeeName" /> <form:errors path="payeeName"
								cssClass="errors"></form:errors></td>
					</tr>
					
					<tr>
					<td><form:label path="accountType"><spring:message text="Account Type:" />
							</form:label></td>
						<td><form:radiobutton path="accountType" value="Current" />Current <form:radiobutton
								path="accountType" value="Savings" />Savings</td>
						<td> <form:errors path="accountType"
								cssClass="errors">
							</form:errors></td>
					</tr>
					<tr>
						<td><form:label path="payeeAccountNo">
								<spring:message text="Payee Account No:" />
							</form:label></td>
						<td><form:input path="payeeAccountNo" /> <form:errors path="payeeAccountNo"
								cssClass="errors"></form:errors>
							<p style="color:red">${promptContent }</p></td>
					</tr>
					<tr>
						<td><form:label path="IFSC">
								<spring:message text="IFSC Code:" />
							</form:label></td>
						<td><form:select path="IFSC" items="${branchNames}" /> <form:errors
								path="IFSC" cssClass="errors">
							</form:errors></td>
					</tr>
					<tr>	
					<td><input type="submit" value="Add Payee" class="btn btn-success" /></td>
					<td><a href="customerhome" class="btn btn-primary">Cancel</a></td>
					</tr>
            	</table>		
            	<form:hidden path="accountNo"  value="${accountNo}"/>	
            	<form:hidden path="composite"  value="${composite}"/>		
			</form:form>

		</div>
	</div>
<%@include file="akascripts.jsp"%>
</body>
</html>