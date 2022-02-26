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
	<section class="relative about-banner">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">Digital Banking</h1>
				<p class="text-white link-nav">
					<a href="#">Home </a> <span class="lnr lnr-arrow-right"></span>
					<a href="#"> Digital Banking</a>
				</p>
			</div>
		</div>
	</div>
	</section>
	<!-- End banner Area -->
	
	
	
	
	
	
	
	
	<section class="recent-blog-area section-gap">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-60 col-lg-9">
							<div class="title text-center">
								<h1 class="mb-10">Experience Digital Simplify your life!</h1>
								<p>Get offers, contact your RM instantly, apply for Products and more!</p>
							</div>
						</div>
					</div>							
					<div class="row">
						<!-- <div class="active-recent-blog-carusel"> -->
							<div class="single-recent-blog-post item">
								
								<div class="details">
									<div class="tags">
										<ul>
																			
										</ul>
									</div>
									<a href="#"><h4 class="title">Onilne Banking</h4></a>
						<p>STARK BANK offers state-of-the-art internet banking facilities
						 to bank in a secure and convenient way skipping the hassle of long 
						 queues or delays from the location of your choice</p>
									
								</div>	
								<div class="thumb">
									<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/onlineb.jpg" alt="">
								</div>
							</div>
							
			
				
							<div class="single-recent-blog-post item">
					
					<div class="details">
						<div class="tags">
							<ul>
								<!-- <li><a href="#">Know more</a></li> -->
							
							</ul>
						</div>
						<a href="#"><h4 class="title">Virtual RM</h4></a>
						<p>Experience face to face interaction through video banking. 
						Conduct banking transactions, get account related informations,
						 product recommendations, offers and deals.</p><br>
						
					</div>
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/videochat.jpg" alt="">
					</div>
				</div>
				<div class="single-recent-blog-post item">
					>
					<div class="details">
						<div class="tags">
							<ul>
							<!-- 	<li><a href="#">Know more</a></li> -->
								
							</ul>
						</div>
						<a href="#"><h4 class="title">STARK Chat!</h4></a>
						<p>Chat with us to get any information related to your account, 
						and get your doublts clear.
						</p>
					
					</div>
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/chat11.jpg" alt="">
					</div>
				</div>
				<div class="single-recent-blog-post item">
					
					<div class="details">
						<div class="tags">
							<ul>
							<!-- 	<li><a href="#">Know more</a></li> -->
							
							</ul>
						</div>
						<a href="#"><h4 class="title" >Secure Banking</h4></a>
						<p>At STARK BANK, it is our continuous endeavor to make you
						 aware of the simple steps to help avoid compromising your 
						 details to online scams such as Phishing, Vishing, Spoofing 
						 etc. In the event of you suspecting any abnormal activity on
						  your STARK BANK Account,immediately inform STARK BANK of the same 
						  to support@starkbank.in </p>
						
					</div>
				<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/secure.jpg" alt="">
					</div>
				</div>
						
						
						</div>
					</div>
			<!-- 	</div> -->	
			</section>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<%-- 
	
	
		<div class="row">
			<div class="active-recent-blog-carusel">
				
				
				
				
					<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/onlineb.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
							
							</ul>
						</div>
						<a href="#"><h4 class="title">Onilne Banking</h4></a>
						<p>STARK BANK offers state-of-the-art internet banking facilities
						 to bank in a secure and convenient way skipping the hassle of long 
						 queues or delays from the location of your choice</p>
						<!-- <h6 class="date">31st January,2018</h6> -->
					</div>
				</div>
				
				
				
				<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/mobilesol.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
								
							</ul>
						</div>
						<a href="#"><h4 class="title">Mobile Solutions</h4></a>
						<p>Now enjoy the convenience of banking on your mobile wherever you go!
						Experience one click payments on partner apps.
						Book tickets for events, travel, pay bills, and recharge .</p>
						<!-- <h6 class="date">31st January,2018</h6> -->
					</div>
				</div>
				<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/paymentsol.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
						
							</ul>
						</div>
						<a href="#"><h4 class="title">Payment Solutions</h4></a>
						<p>Providing payment solutions using digital technologies. 
						Payment through mobile and Net Banking.</p>
						<!-- <h6 class="date">31st January,2018</h6> -->
					</div>
				</div>
				<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/videochat.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
							
							</ul>
						</div>
						<a href="#"><h4 class="title">Virtual RM</h4></a>
						<p>Experience face to face interaction through video banking. 
						Conduct banking transactions, get account related informations,
						 product recommendations, offers and deals.</p>
					<!-- 	<h6 class="date">31st January,2018</h6> -->
					</div>
				</div>
				<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/chat11.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
								
							</ul>
						</div>
						<a href="#"><h4 class="title">STARK Chat!</h4></a>
						<p>Chat with us to get any information related to your account, 
						and get your doublts clear.
						</p>
					<!-- 	<h6 class="date">31st January,2018</h6> -->
					</div>
				</div>
				<div class="single-recent-blog-post item">
					<div class="thumb">
						<img class="img-fluid" src="${pageContext.request.contextPath}/webjars/img/secure.jpg" alt="">
					</div>
					<div class="details">
						<div class="tags">
							<ul>
								<li><a href="#">Know more</a></li>
							
							</ul>
						</div>
						<a href="#"><h4 class="title">Secure Banking</h4></a>
						<p>At STARK BANK, it is our continuous endeavor to make you
						 aware of the simple steps to help avoid compromising your 
						 details to online scams such as Phishing, Vishing, Spoofing 
						 etc. In the event of you suspecting any abnormal activity on
						  your STARK BANK Account,immediately inform STARK BANK of the same 
						  to support@starkbank.in </p>
						<!-- <h6 class="date">31st January,2018</h6> -->
					</div>
				</div>

			</div>
		</div>
	</div>
	</section> --%>
	<!-- start footer Area -->
<%@include file="footer.jsp"%>
	<!-- End footer Area -->

	<%@include file="scripts.jsp"%>
</body>
</html>