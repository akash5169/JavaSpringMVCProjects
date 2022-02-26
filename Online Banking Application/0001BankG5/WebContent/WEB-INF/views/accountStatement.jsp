<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement Home</title>
<%@include file="akalinks.jsp"%>
<style>
.ui-datepicker .ui-datepicker-title select {
    color:#f00;
    
}
.body-area3{
background:url(./webjars/img/paris-event-location.jpg) ;

background-repeat: no-repeat;
    background-size:1500px 1500px;
    }
</style>

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
						$(function() {
							$('input[id$=startDate]').datepicker({dateFormat:'mm-dd-yy',
								showOtherMonths:true,
								selectOtherMonths:true,
								minDate:"01-01-1991",
								maxDate:"12-31-2050",
								changeMonth:true,
								changeYear:true,
								yearRange:"1990:2050"});
							$('#startDate').datepicker();
							$('#startDate').datepicker("show");
						});
						
				
						$(function() {
							$('input[id$=endDate]').datepicker({dateFormat:'mm-dd-yy',
								showOtherMonths:true,
								selectOtherMonths:true,
								minDate:"01-01-1991",
								maxDate:"12-31-2050",
								changeMonth:true,
								changeYear:true,
								yearRange:"1990:2050"});
							$('#endDate').datepicker();
							$('#endDate').datepicker("show");
						});
						
						$(function() {
							$('input[id$=intervalDate]').datepicker({dateFormat:'mm-dd-yy',
								showOtherMonths:true,
								selectOtherMonths:true,
								minDate:"01-01-1991",
								maxDate:"12-31-2050",
								changeMonth:true,
								changeYear:true,
								yearRange:"1990:2050"});
							$('#intervalDate').datepicker();
							$('#intervalDate').datepicker("show");
						});
						

						
	</script>

</head>
<body class="body-area3">
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
	<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="panel-heading" style="text-align:center"><h4>Account Statement by Date</h4></div>
			<div class="panel-body">
			
	
	<c:url var="myaction" value="/accountStatementByDate"></c:url>
	<form:form name="form" action="${myaction}" method="get"
		modelAttribute="userDate">
		<table>
			<tr>
				<td><form:label path="startDate">
						<spring:message text="Enter Start Date:" />
					</form:label> <form:input type="text" name="startDate" id="startDate"
						path="startDate" required="required"  autocomplete="off"/> <form:errors
						path="startDate" cssClass="errors"></form:errors> </td>
						
			</tr>
			<tr>
				<td><form:label path="endDate">
						<spring:message text="Enter Ending Date:" />
					</form:label> <form:input type="text" name="endDate" id="endDate" path="endDate"
						required="required" autocomplete="off" /> <form:errors path="endDate"
						cssClass="errors"></form:errors></td>
						
						
						<td>${promptcontent}</td>
				<td><input type="submit" value="Submit" class="btn btn-success" />
				</td>
				
			</tr>
		</table>
	</form:form>
	</div>
	</div>
<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="panel-heading" style="text-align:center"><h4>Account Statement By Month</h4></div>
			<div class="panel-body">

	<c:url var="myaction" value="/accountStatementByMonth"></c:url>
	<form:form name="form" action="${myaction}" method="get"
					modelAttribute="userDate">
					<table>
			<tr>
				<td>
					<form:label path="chosenMonth">
						<spring:message text="Enter the month:" />
					</form:label>
					<form:select path="chosenMonth" required="required">
						<form:option value="Jan">Jan</form:option>
						<form:option value="Feb">Feb</form:option>
						<form:option value="Mar">Mar</form:option>
						<form:option value="Apr">Apr</form:option>
						<form:option value="May">May</form:option>
						<form:option value="Jun">Jun</form:option>
						<form:option value="Jul">Jul</form:option>
						<form:option value="Aug">Aug</form:option>
						<form:option value="Sept">Sept</form:option>
						<form:option value="Oct">Oct</form:option>
						<form:option value="Nov">Nov</form:option>
						<form:option value="Dec">Dec</form:option>
					</form:select>
					<form:errors path="chosenMonth" cssClass="errors"></form:errors>
					<td><input type="submit" value="Submit" class="btn btn-success" />
					</td>
						</tr>
	</table>
				</form:form>
	
	</div>
	</div>
	
	<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="panel-heading" style="text-align:center"><h4>Account Statement By Month</h4></div>
			<div class="panel-body">
	
	<h2>By 6 Months</h2>
	<h5>Note:The queries are only retrieved for the past 6 months from
		current date</h5>
	<c:url var="myaction" value="/accountStatementByHalf"></c:url>
	<form:form name="form" action="${myaction}" method="get"
					modelAttribute="userDate">
					<table>
		<tr>
			<td>
					<form:label path="intervalDate"></form:label>
					<form:input type="text" name="intervalDate" id="intervalDate"
						path="intervalDate" required="required"  autocomplete="off"/>
					<form:errors path="intervalDate" cssClass="errors"></form:errors>
					<td><input type="submit" value="Submit" class="btn btn-success" />
					</td>
						</tr>
	</table>
				</form:form>
	
	</div>
	</div>

	
	
	
	<div class="panel panel-default col-md-12 ">
			<div class="panel-heading" style="text-align:center"><h3>Account Statement</h3></div>
			<div class="panel-body">
			
	
	<table class="table table-bordered">
		<tr>
			<td width="80">Transaction Id</td>
			<td width="80">Transaction Amount</td>
			<td width="120">Transaction Date and Time</td>
			<td width="100">Sender Account Number</td>
			<td width="100">Receiver Account Number</td>
			<td width="90">Transaction Type</td>
			<td width="90">Available Balance</td>
			<td width="90">Account No</td>
		</tr>
		<c:forEach items="${transactionList}" var="transaction">
			   <tr>
					<td>${transaction.transactionId}</td>
					<td>${transaction.transactionAmount }</td>
					<td>${transaction.transactionDateTime}</td>
					<td>${transaction.senderAccountNo}</td>
					<td>${transaction.receiverAccountNo}</td>
					<td>${transaction.transactionType}</td>
					<td>${transaction.availableBalance}</td>
					<td>${transaction.account.accountNo}</td>
				</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	
	</div>
	<%@include file="akascripts.jsp"%>
</body>
</html>