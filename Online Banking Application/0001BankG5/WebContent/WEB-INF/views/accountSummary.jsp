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
<%@include file="akalinks.jsp"%>
<title>Account Summary</title>
<style>
.body-area4{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
    }</style>
</head>
<body class="body-area4">
<br>
<br>
<div style=" position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
    ;">
    
<a href="<c:url value='/customerhome' />" class="btn btn-primary">Back</a>
</div>

<div class="container" style="padding: 20px">
	<div class="panel panel-default col-md-12 ">
			<div class="panel-heading" style="text-align:center"><h3>Account Statement</h3></div>
			<div class="panel-body">
	<h1>Account Summary Details</h1>
	Account Number:${account.accountNo}
	<br />
	<hr>
	Account Balance:${account.accountBalance}
	<br>
	<hr>
	Account Type:${account.accountType}
	<br>
	<hr>
	Account IFSC:${account.IFSC}
	<br>
	<hr>
	<h1>Transaction Details</h1>
	<table class="table table-bordered">

		<tr>
		<td width="80">Transaction Id</td>
		<td width="100">Account No</td>
			<td width="80">Transaction Amount</td>
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
	</div>
	</div>
	</div>

	
	

	<%@include file="akascripts.jsp"%>
</body>
</html>