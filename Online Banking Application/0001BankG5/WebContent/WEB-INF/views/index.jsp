<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="akalinks.jsp"%>
<%@include file="links.jsp"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->

<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Bank</title>
<script>
window.onload = function () { history.forward(); };
</script>
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"> -->

</head>


<body>
	
	
<%@include file="header.jsp"%>
	<section class="banner-area relative">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row fullscreen align-items-center justify-content-between">
					<div class="col-lg-6 col-md-6 banner-left" style="
    margin: 85px 446px -387px 6px;">
				<h6 class="text-white">Customer comes first</h6>
				<h1 class="text-white" style="font-family: Consolas">Experience
					Stark</h1>
				<p class="text-white">We see our customers as invited guests to
					a party, and we are the hosts. It's our job every day to make every
					important aspect of the customer experience a little better.</p>
					
				<a  href="<c:url value='/registration' />" class="primary-btn text-uppercase">Register</a>
						
				
			</div>
	
				
	<div class="container" style="margin-left:30px">
		<div class="panel panel-default col-md-4 col-md-offset-8">
			<div class="panel-heading" style="text-align:center"><h3>LOGIN</h3></div>
			<div class="panel-body">
			<c:url var="myaction" value="/dologin"></c:url>
			<form:form action="${myaction}" method="get" modelAttribute="login">
				<table>
					<tr>
						<td><form:label path="userId"><spring:message text="UserId" />
							</form:label></td>
						<td><form:input path="userId" /> 
						<form:errors path="userId" cssClass="errors"></form:errors></td>
					</tr>
<br>

					<tr>
						<td><form:label path="password"><spring:message text="Password" />
							</form:label></td>
						<td><form:input type="password" path="password" /> <form:errors path="password"
								cssClass="errors"></form:errors></td>
					</tr>
					<br>
					<tr>
					<td><input type="submit" value="Login" class="primary-btn text-uppercase" /></td>
					<%-- <td><a href="<c:url value='#' />" >Forgot Password?</a></td> --%>
					</tr>
					
					<tr>
					<td><p style="color:red">${promptContent}</p></td>
					</tr>
					</table>
					</form:form>
					<br>
                     <%-- <a href="<c:url value='/registration' />" class="btn btn-primary">Register</a> --%>
                     
			</div>
		</div>
	</div>
		</div>
	</div>

	</section>
		<section class="top-category-widget-area pt-90 pb-90 ">
				<div class="container">
				<div class="row d-flex justify-content-center">
						
					</div>
					<div class="row">		
						<div class="col-lg-4">
							<div class="single-cat-widget">
								<div class="content relative">
									<div class="overlay overlay-bg"></div>
								    <a href="#" target="_blank">
								      <div class="thumb">
								  		 <img class="content-image img-fluid d-block mx-auto" 
								  		 src="${pageContext.request.contextPath}/webjars/img/home.jpg" alt="">
								  	  </div>
								      <div class="content-details">
								        <h4 class="content-title mx-auto text-uppercase">Home Loan</h4>
								        <span></span>								        
								        <p>Now have your own home.</p>
								      </div>
								    </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="single-cat-widget">
								<div class="content relative">
									<div class="overlay overlay-bg"></div>
								    <a href="#" target="_blank">
								      <div class="thumb">
								  		 <img class="content-image img-fluid d-block mx-auto" src="${pageContext.request.contextPath}/webjars/img/car1.jpg" alt="">
								  	  </div>
								      <div class="content-details">
								        <h4 class="content-title mx-auto text-uppercase">Car Loan</h4>
								        <span></span>								        
								        <p>Why to travel in rikshaw when</br> you can have your own Car.</p>
								      </div>
								    </a>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="single-cat-widget">
								<div class="content relative">
									<div class="overlay overlay-bg"></div>
								    <a href="#" target="_blank">
								      <div class="thumb">
								  		 <img class="content-image img-fluid d-block mx-auto" 
								  		 src="${pageContext.request.contextPath}/webjars/img/gold.jpg" alt="">
								  	  </div>
								      <div class="content-details">
								        <h4 class="content-title mx-auto text-uppercase">Gold Loan</h4>
								        <span></span>
								        <p>Save , Secure and at best rates.</p>
								      </div>
								    </a>
								</div>
							</div>
						</div>												
					</div>
				</div>	
			</section>
	
	<%@include file="footer.jsp"%>
	<!-- End footer Area -->
	<%@include file="scripts.jsp"%>
	<%@include file="akascripts.jsp"%>
</body>

</html>