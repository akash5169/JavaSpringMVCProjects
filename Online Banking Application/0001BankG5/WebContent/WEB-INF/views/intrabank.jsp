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
<title>Intra Bank</title>
<style>
.body-area5{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
    }</style>
<%@include file="akalinks.jsp"%>
<script>
   window.onload = function () { history.forward(); };
</script>
<style>
.ui-datepicker .ui-datepicker-title select {
    color:#f00;
}

</style>
<link
href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
rel="stylesheet"/>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<body class="body-area5">
<div style=" position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
    ;">
    
<a href="<c:url value='/customerhome' />" class="btn btn-primary">Back</a>
</div>
<br>
<br>
<br>

<div class="container" style="padding: 20px">
		<div class="panel panel-default col-md-4 col-md-offset-4">
			<div class="panel-heading"><h3>Fund Transfer</h3></div>
			<div class="panel-body">
	<c:url var="myaction" value="/tryFundTransfer"></c:url>
	<form:form action="${myaction}" method="get" modelAttribute="transaction">
		<table class="table ">
			<tr>

               <tr>
						<td><form:label path="receiverName">
								<spring:message text="Select Payee:" />
							</form:label></td>
						<td><form:select path="receiverName" items="${payeeNames}" required="required"/> <form:errors
								path="receiverName" cssClass="errors">
							</form:errors></td>
					</tr>
			<tr>

				<td><form:label path="transactionType">
						<spring:message text="Enter a note for transaction" />
					</form:label></td>
				<td><form:input path="transactionType" /> <form:errors path="transactionType"
						cssClass="errors"></form:errors></td>
			</tr>
			<%-- <tr>
			<td><form:label path="transactionDateTime">
								<spring:message text="Date :(dd-MM-yyyy)" />
							</form:label></td>
						<td>
						<form:input type="text" id="transactionDateTime" path="transactionDateTime" required="required" autocomplete="off" /> 
						<form:errors path="transactionDateTime" cssClass="errors"></form:errors></td>
						<td>
						<script type="text/javascript">
						$(function() {
							 var now=new Date();  
							 var limit=now.getFullYear();
						   $('input[id$=transactionDateTime]').datepicker({dateFormat:'mm-dd-yy',
								showOtherMonths:true,
								selectOtherMonths:true,	
								changeMonth:true,
								changeYear:true,
							     yearRange:"-90:+1"
							});
							$('#transactionDateTime').datepicker();
							$('#transactionDateTime').datepicker("show");
						});
						</script>
			</tr> --%>
                 
             <tr>
                <td><form:label path="transactionAmount">
						<spring:message text="Enter Amount" />
					</form:label></td>
				<td><form:input path="transactionAmount" /> <form:errors path="transactionAmount"
						cssClass="errors"></form:errors></td>
						<td>${promptContent}</td>
			</tr>
			<tr>
			<td><input type="submit" value="Transfer" class="btn btn-success" /></td>
			<td><a href="<c:url value='/customerhome' />" class="btn btn-primary">Cancel</a></td>
            </tr>
            <form:hidden path="receiverAccountNo" value="${receiverAccountNo}" />
            <form:hidden path="account.accountNo" value="${account.accountNo}" />
            <form:hidden path="senderAccountNo" value="${senderAccountNo}" />
		<form:hidden path="transactionDateTime" value="${transactionDateTime}" />
		<form:hidden path="transactionId" value="${transactionId}" />
		<form:hidden path="availableBalance" value="${availableBalance}" />
		</table>
	</form:form>
	</div>
	</div>
	</div>
<%@include file="akascripts.jsp"%>
</body>
</html>