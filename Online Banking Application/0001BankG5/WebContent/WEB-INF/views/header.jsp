
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>


  <%@include file="links.jsp" %>
</head>
<body>

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
				<a href="#"> <img
					src="${pageContext.request.contextPath}/webjars/img/logo1.jpg"
					alt="" title="" /></a>


			</div>


			<nav id="nav-menu-container">
			<ul class="nav-menu">
				<li><a href="<c:url value='/'/>">Home</a></li>
				<li><a href="<c:url value='/digital' />">Digital Banking</a></li>
				<li><a href="<c:url value='/about' />">About Us</a></li>
				<!-- <li class="menu-has-children "><a href="#">Services</a>
					<ul>
						<li><a href="#">IndividualBanking</a></li>
						<li><a href="#">Business Banking</a></li>
						<li><a href="#">Digital Banking</a></li>
						<li><a href="#">Loans</a></li>
					</ul></li>

				<li class="menu-has-children"><a href="#">Products</a>
					<ul>
						<li><a href="#">Loans</a></li>
						<li><a href="#">Transactional Account</a></li>
						<li><a href="#">Savings Account</a></li>
						<li><a href="#">Debit Card</a></li>
						<li><a href="#">Credit Card</a></li>
						<li><a href="#">Travellers Cheque</a></li>


					</ul></li> -->



				<li><a href="<c:url value='/map' />">Locate Us</a></li>



				<li><a href="<c:url value='/contact' />">Contact</a></li>
			</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</div>
	</header>
  <%@include file="scripts.jsp" %>
</body>
</html>