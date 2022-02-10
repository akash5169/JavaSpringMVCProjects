
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
  background-repeat: repeat;
  background-size: cover;
  color: #f3f1ed;
}

.coverPhoto{
  background: rgba(0, 0, 0, 0.7);
}

.coverPhoto1{
  background: rgba(0, 0, 0, 0.8);
}


</style>
</head>
<body class="bg">

<c:url var="indexpage" value="/logout"></c:url>
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
                <li role="presentation" >&nbsp;&nbsp;</li>
                <li role="presentation" ><a style="color: #d1dbe4;" href="${indexpage}">HOME</a></li>
                <li role="presentation" ><a style="color: #d1dbe4;" href="${offerpage}">OFFERS</a></li>
                <li role="presentation" class="active"><a href="">OUR TEAM</a></li> 
            </ul>       
        </div>
    </div>

<div class="container coverPhoto1" style="position: absolute; width:100%">

<h1 align="center"><i>Akash Shinde</i></h1> <!-- Center alignment -->
<center>
<img style="border: 5px solid #999;" src="${pageContext.request.contextPath}/webjars/images/akash.jpg"  high = "20%" width = "20%"/>
</center>

<!-- Information about myself -->
<p align="center"><i> Hello!,<br/> I'm Akash Shinde. I have done my bachelors degree in Computer Engineering after which I worked as Software Engineer at L&T Infotech for two years. </i></p>
<p align="center"></p>

<p align="center">I have done my bachelors degree in Computer Engineering after which I worked as Software Engineer at L&T Infotech for two years. I have
            experience of working with JAVA, Python, and Angular JS languages</p> 
            
<!-- Adding my Tableau Repository link -->

<p align="center"> As a masters student, my curriculum is concentrated towards data science and analytics. I enjoy data extraction, wrangling, mining, modeling and visualizing. You can view my Github repository here: 
<a
href="https://github.com/akash5169"
target= "_blank"
>
Github Repository
</a>
I'll be graduating in June 2022 and I am enjoying my time here at UIC. 
</p>


<h1 align="center"><i>Jigyasa Sachdeva</i></h1> <!-- Center alignment -->
<center>
<img style="border: 5px solid #999;" src="${pageContext.request.contextPath}/webjars/images/IMG_3164.jpg"  high = "20%" width = "20%"/>
</center>

<!-- Information about myself -->
<p align="center"><i> Hello!,<br/> I'm Jigyasa Sachdeva. This is the first time I have built a website. I am hopeful that you all would enjoy viewing it. </i></p>
<p align="center"></p>

<p align="center"> I enjoy traveling and exploring food outlets on weekends. I usually read non-fiction novels and my favorite is The Power of Now' which talks about living the current moment with detachments from past and future. I am a Potterhead, Harry Potter books are my go-to for the fantasy land. Additionally, I have been painting and sketching since I was 6 years old. Art and craft is meditation to me and keeps me creative! 
</p>

<!-- Adding my Tableau Repository link -->

<p align="center"> As a masters student, my curriculum is concentrated towards data science and analytics. I enjoy data extraction, wrangling, mining, modeling and visualizing. You can view my Tableau repository here: 
<a
href="https://public.tableau.com/profile/jigyasa.sachdeva#!/"
target= "_blank"
>
Tableau Repository
</a>
I'll be graduating this May and I will always cherish my time at UIC. 
</p>


<h1 align="center"><i>Balamurugan Sithanathan</i></h1> <!-- Center alignment -->
<center>
<img style="border: 5px solid #999;" src="${pageContext.request.contextPath}/webjars/images/bala.jpg"  high = "20%" width = "20%"/>
</center>

<!-- Information about myself -->
<p align="center"><i> Hello!,<br/> I'm Balamurugan Sithanathan. I have done my bachelors degree in Mechanical Engineering after which I worked as Software Engineer at Cognizant for two years.  </i></p>
<p align="center"></p>

<p align="center"> I enjoy traveling and exploring food outlets on weekends. I usually read non-fiction novels and my favorite is The Power of Now' which talks about living the current moment with detachments from past and future. I am a Potterhead, Harry Potter books are my go-to for the fantasy land. Additionally, I have been painting and sketching since I was 6 years old. Art and craft is meditation to me and keeps me creative! 
</p>

<!-- Adding my Tableau Repository link -->

<p align="center"> As a masters student, my curriculum is concentrated towards data science and analytics. I enjoy data extraction, wrangling, mining, modeling and visualizing. You can view my Tableau repository here: 
<a
href="https://public.tableau.com/profile/jigyasa.sachdeva#!/"
target= "_blank"
>
Tableau Repository
</a>
I'll be graduating this May and I will always cherish my time at UIC. 
</p>

<h1 align="center"><i>Zeel Patel</i></h1> <!-- Center alignment -->
<center>
<img style="border: 5px solid #999;" src="${pageContext.request.contextPath}/webjars/images/zeel.jpg"  high = "20%" width = "20%"/>
</center>

<!-- Information about myself -->
<p align="center"><i> Hello!,<br/> I'm Zeel Patel. This is the first time I have built a website. I am hopeful that you all would enjoy viewing it. </i></p>
<p align="center"></p>

<p align="center"> A self-motivated enthusiastic student with leadership skills. I have always been a team player and know how to handle difficult situations.</p>

<!-- Adding my Tableau Repository link -->

<p align="center"> As a masters student, my curriculum is concentrated towards data science and analytics. I enjoy data extraction, wrangling, mining, modeling and visualizing. You can view my Tableau repository here: 
<a
href="https://public.tableau.com/profile/jigyasa.sachdeva#!/"
target= "_blank"
>
Tableau Repository
</a>
I'll be graduating this May and I will always cherish my time at UIC. 
</p>
</div>
</body>
</html>