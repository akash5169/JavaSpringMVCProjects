<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="akalinks.jsp"%>
<%@include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
window.onload = function () { history.forward(); };
</script>
</head>
<body >



<header id="header">
	<div class="header-top">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-sm-6 col-6 header-top-left">
					<!-- <ul>
						<li><a href="#">About Us</a></li>

					</ul> -->
				</div>
				<div class="col-lg-6 col-sm-6 col-6 header-top-right">
					<div class="header-social">
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"> <i
							class="fa fa-linkedin"></i></a> <a href="#"><i
							class="fa fa-google"></i></a>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container main-menu">
		<div class="row align-items-center justify-content-between d-flex">
			<div id="logo">
				<a href="<c:url value='/customerhome' />"> <img
					src="${pageContext.request.contextPath}/webjars/img/logo1.jpg"
					alt="" title="" /></a>


			</div>


			<nav id="nav-menu-container">
			<ul class="nav-menu">
			
				<li><a href="<c:url value='/viewProfile' />">View Profile</a></li>
				<li><a href="<c:url value='/accountStatement' />">Account Statement</a></li>
				<li><a href="<c:url value='/viewAccountSummary' />">Account Summary</a></li>
				<li><a href="<c:url value='/showIntraBankFundTransferPage' />">Fund Transfer</a></li>

				<li><a href="<c:url value='/payee' />">Add Payee</a></li>


                <li><a href="<c:url value='/imageUpload' />">Image Upload</a></li>
				<li><a href="<c:url value='/showChangePasswordPage' />">Change Password</a></li>
				<li><a href="<c:url value='/doLogout' />">Logout</a></li>
			</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</div>
	</header>
		<section class="banner-area relative">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row fullscreen align-items-center justify-content-between">
					<div class="col-lg-6 col-md-6 banner-left" >
				
				<h1 class="text-white" style="font-family: Consolas">You have successfully logged in!</h1>
				<!-- <p class="text-white">We see our customers as invited guests to
					a party, and we are the hosts. It's our job every day to make every
					important aspect of the customer experience a little better.</p>
					
				<a href="reg_success.jsp" class="primary-btn text-uppercase">Register</a>
						<a href="payee_success.jsp" class="primary-btn text-uppercase">Payee</a>
							<a href="reg_success.jsp" class="primary-btn text-uppercase">Rform</a>
								<a href="profile.jsp" class="primary-btn text-uppercase">Profile</a>
								<a href="registrationsuccess.jsp" class="primary-btn text-uppercase">rsuccess</a> -->
					
				
			</div>
	
				
	
		</div>
	</div>

	</section>
	
<%-- 		<section class="top-category-widget-area pt-90 pb-90 ">
				<div class="container">
				<div class="menu-content pb-60 col-lg-9">
							<div class="title text-center">
								<h1 class="mb-10">You are successfullu logged in!</h1>
								<p>You can also try.</p>
							</div>
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
			</section> --%>












<%@include file="akascripts.jsp"%>
<%@include file="scripts.jsp"%>
</body>
</html>













