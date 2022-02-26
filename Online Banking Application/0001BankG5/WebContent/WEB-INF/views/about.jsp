<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="links.jsp"%>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
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


</head>
<body>
	<%@include file="header.jsp"%>

	<!-- #header -->


	<!-- start banner Area -->
	<section class="about-banner relative">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">About Us</h1>
				<p class="text-white link-nav">
					<a href="#">Home </a> <span class="lnr lnr-arrow-right"></span>
					<a href="#"> Contact Us</a>
				</p>
			</div>
		</div>
	</div>
	</section>
	<!-- End banner Area -->

	<!-- Start about-info Area -->
	<section class="about-info-area section-gap">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 info-left">
				<img class="img-fluid" src="webjars/img/about.jpeg" alt="">
			</div>
			<div class="col-lg-6 info-right">
				<h6>About Us</h6>
				<h1>Who We Are?</h1>
				<p>Our relationships are built on trust that we build every day
					through every interaction. Our employees are empowered to do the
					right thing to ensure they share our customers’ vision for
					success. We work as a partner to provide financial products and
					services that make banking safe, simple and convenient. We’re
					here to help navigate important milestones and strengthen futures
					together.
			</div>
		</div>
	</div>
	</section>
	<!-- End about-info Area -->

	<!-- Start price Area -->
<%-- 	<section class="price-area section-gap">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="menu-content pb-70 col-lg-8">
				<div class="title text-center">
					<h1 class="mb-10">This is Us</h1>
					<p>We created this</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>



			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="single-sidebar-widget user-info-widget">
					<img
						src="${pageContext.request.contextPath}/webjars/img/blog/user-info.png"
						alt=""> <a href="#"><h4>Charlie Barber</h4></a>
					<p>Senior blog writer</p>
					<ul class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-github"></i></a>
						<a href="#"><i class="fa fa-behance"></i></a>
					</ul>
					<p>Boot camps have its supporters andit sdetractors. Some
						people do not understand why you should have to spend money on
						boot camp when you can get. Boot camps have itssuppor ters andits
						detractors.</p>
				</div>
			</div>
		</div>

	</div>
	</div>
	</section> --%>
	<%@include file="footer.jsp"%>
	<!-- End footer Area -->
	<%@include file="scripts.jsp"%>
</body>
</html>