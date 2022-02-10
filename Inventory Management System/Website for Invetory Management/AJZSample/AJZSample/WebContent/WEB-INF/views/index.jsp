
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="resolink.jsp"%>
<script>
	window.onload = function() {
		history.forward();
	};
</script>

<style>

.arrange-horizontally > * {
    display: inline-block;
    text-align: center;
}

/* Class to arrange divs verically */
.arrange-vertically > * {
    display: block;
}


body, html {
  height: 100%;
}

.bg {
  /* The image used */
  background-image: url("${pageContext.request.contextPath}/webjars/images/loginBG.jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
.table>tbody>tr>td,
.table>tbody>tr>th {
  border-top: none;
}

.coverPhoto{
  background: rgba(0, 0, 0, 0.7);
}


</style>
</head>
<body class="bg">

<c:url var="aboutus" value="/aboutus"></c:url>
<c:url var="offerpage" value="/offerpage"></c:url>

<div class="arrange-horizontally coverPhoto">
        
        <div class="arrange-vertically" style="width: 100%;">
            <div style="align-items: center; width: 100%;">
            <h1 style="color: rgb(205 226 226); font-size: 45px; font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif">AJZB MART</h1>
            </div>

            <div style="align-items: center; width: 100%;">
            <p style="margin-bottom: 0px; color: rgb(204 184 210); font-size: 25px; font-family:Brush Script MT, Brush Script Std, cursive">Welcome to our website</p>
            </div>
            <!-- Using list for showing tabs to go to different webpages -->
            <ul class="nav nav-tabs">
                <!--Using active class to highlight the tab  -->
                <li role="presentation" >---</li>
                <li role="presentation" class="active"><a href="">HOME</a></li>
                <li role="presentation" ><a style="color: #d1dbe4;" href="${offerpage}">OFFERS</a></li>
                <li role="presentation" ><a style="color: #d1dbe4;" href="${aboutus}">OUR TEAM</a></li> 
            </ul>       
        </div>
    </div>


	<div class="container" style="position: absolute; top: 31%; ">
		<div class="panel panel-default col-md-4 col-md-offset-5" style="border: 5px solid #999; background: rgba(0, 0, 0, 0.75); border-color: #542626;">
			<div class="panel-heading" style="text-align: center; color: #a23e3e; background-color: #d69b24; border-color: #540e0e;">
				<h2>LOGIN</h2>
			</div>
			<div class="panel-body">
				<c:url var="myaction" value="/dologin"></c:url>
				<form:form action="${myaction}" method="post" modelAttribute="login">
					<table class="table" style="margin-bottom: 0px;">
						<tr>
							<td><form:label style="color: rgb(205 226 226);" path="username"><spring:message text="USERNAME" /></form:label></td>
							<td><form:input path="username" required="required" autocomplete="off"/></td>
						</tr>
						<tr>
							<td><form:label style="color: rgb(205 226 226);" path="password"><spring:message text="PASSWORD" /></form:label></td>
							<td><form:input type="password" required="required" path="password" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Login" class="btn btn-success text-uppercase" /></td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
					<p style="color: red">${promptContent}</p>
				</form:form>
			</div>
		</div>
	</div>
<%@include file="resoscripts.jsp"%>
</body>

</html>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to my website</title>
</head>
<body>

<h1>Connected</h1>
</body>
</html> --%>
