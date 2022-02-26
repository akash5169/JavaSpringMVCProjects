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
<title>Inter Bank</title>
</head>
<body>

<h1>Welcome to Inter-Bank Transfer</h1>
	<c:url var="myaction" value="/finalPageInter"></c:url>
	<form:form action="${myaction}" method="get" modelAttribute="addPayee">
		<table class="table ">
			<tr>

				<td><form:label path="payeeName">
						<spring:message text="Payee Name" />
					</form:label></td>
				<td><form:select path="payeeName">
				
					</form:select></td>
			</tr>
			<tr>

				<td><form:label path="amount">
						<spring:message text="Amount" />
					</form:label></td>
				<td><form:input path="amount" /> <form:errors path="amount"
						cssClass="errors"></form:errors></td>
			</tr>

			<tr>

				<td><form:label path="accountType">
						<spring:message text="Account Type" />
					</form:label></td>
				<td><form:select path="accountType">
						<form:option value="NONE" label="Select" />
						<form:option value="Saving" label="Savings" />
						<form:option value="Current" label="Current" />
					</form:select> <form:errors path="accountType" cssClass="errors"></form:errors></td>
					<td><input type="submit" value="Submit" class="btn btn-success" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>