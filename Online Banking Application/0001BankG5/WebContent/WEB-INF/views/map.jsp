<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<section class="relative about-banner">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">Locate Us</h1>
				<p class="text-white link-nav">
					<a href="#">Home </a> <span class="lnr lnr-arrow-right"></span> <a
						href="#"> Contact Us</a>
				</p>
			</div>
		</div>
	</div>
	</section>
	<!-- End banner Area -->
	
	<div  align="center" style="width:100%">
	
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3769.9539494242745!2d73.02855801437725!3d19.109676055880207!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c0fa95ff1789%3A0xed94f90522f1346b!2sL%26T+Infotech!5e0!3m2!1sen!2sin!4v1538299563891"
			width="600" height="450" frameborder="0" style="border: 0"
			allowfullscreen></iframe>
	</div>
	

	<!-- Start contact-page Area -->
	<%-- <section class="contact-page-area section-gap">
	<div class="container">
		<div class="row">
			<div class="map-wrap" style="width: 100%; height: 445px;" id="map"></div>
			<div class="col-lg-4 d-flex flex-column address-wrap">
				<div class="single-contact-address d-flex flex-row">
					<div class="icon">
						<span class="lnr lnr-home"></span>
					</div>
					<div class="contact-details">
						<h5>Binghamton, New York</h5>
						<p>4343 Hinkle Deegan Lake Road</p>
					</div>
				</div>
				<div class="single-contact-address d-flex flex-row">
					<div class="icon">
						<span class="lnr lnr-phone-handset"></span>
					</div>
					<div class="contact-details">
						<h5>00 (958) 9865 562</h5>
						<p>Mon to Fri 9am to 6 pm</p>
					</div>
				</div>
				<div class="single-contact-address d-flex flex-row">
					<div class="icon">
						<span class="lnr lnr-envelope"></span>
					</div>
					<div class="contact-details">
						<h5>support@colorlib.com</h5>
						<p>Send us your query anytime!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<form class="form-area contact-form text-right" id="myForm"
					action="mail.php" method="post">
					<div class="row">
						<div class="col-lg-6 form-group">
							<input name="name" placeholder="Enter your name"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter your name'"
								class="common-input mb-20 form-control" required="" type="text">

							<input name="email" placeholder="Enter email address"
								pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter email address'"
								class="common-input mb-20 form-control" required="" type="email">

							<input name="subject" placeholder="Enter subject"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter subject'"
								class="common-input mb-20 form-control" required="" type="text">
						</div>
						<div class="col-lg-6 form-group">
							<textarea class="common-textarea form-control" name="message"
								placeholder="Enter Messege" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter Messege'" required=""></textarea>
						</div>
						<div class="col-lg-12">
							<div class="alert-msg" style="text-align: left;"></div>
							<button class="genric-btn primary" style="float: right;">Send
								Message</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section> --%>
	<!-- End contact-page Area -->

	<!-- start footer Area -->
	<%@include file="footer.jsp"%>
	<!-- End footer Area -->

	<%@include file="scripts.jsp"%>
</body>
</html>