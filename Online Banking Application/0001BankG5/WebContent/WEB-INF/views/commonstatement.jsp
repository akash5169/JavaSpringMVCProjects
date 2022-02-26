<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Required Account Statement </title>
<%@include file="akalinks.jsp"%>
</head>
<body>
<h1>Account Statement</h1>
	<table class="table table-bordered">
		<tr>
			<td width="80">Transaction Id</td>
			<td width="100">Account No</td>
			<td>Transaction Amount</td>
			<td width="120">Transaction Date and Time</td>
			<td width="100">Sender Account Number</td>
			<td width="100">Receiver Account Number</td>
			<td width="90">Transaction Type</td>
			<td width="90">Available Balance</td>
			
		</tr>
		<c:forEach items="${transactionList}" var="transaction">
			  <tr>
					<td>${transaction.transactionId}</td>
					<td>${transaction.account.accountNo }</td>
					<td>${transaction.transactionAmount }</td>
					<td>${transaction.transactionDateTime}</td>
					<td>${transaction.senderAccountNo}</td>
					<td>${transaction.receiverAccountNo}</td>
					<td>${transaction.transactionType}</td>
					<td>${transaction.availableBalance}</td>
					
			</tr>
		</c:forEach>
	</table>
		<%@include file="akascripts.jsp"%>
</body>
</html>