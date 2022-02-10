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
<title>Offers Page</title>
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

/* Class to hide images */
.mySlides {display:none}

/* Class to Crop images in fixed width and height */
.imgsizer {
    width:  600px;
    height: 500px;
    background-repeat:   no-repeat;
    display: block;
    margin-left: auto;
    margin-right: auto; 
    border: 5px solid #999;
     
}

/* Class to change opacity of image */
.rss.opacity { filter: opacity(90%); }

.column1 {
    float: left;
    width: 25%;
    padding: 20px;
  }

  /* Class to create a dot using span */              
  .mybadge
  {
    height: 13px;
    width: 13px;
    padding: 0;
    border-radius: 50%;
  }
/* Class to give style to dots */
  .myborder
  {
    border: 1px solid #ccc!important;
    color: #fff!important;
    background-color: #000!important;
  }

  /* Class to give style to dots */
  .w3-white, .w3-hover-white:hover {
    color: #000!important;
    background-color: rgb(160, 224, 8)!important;
}

.mybox{
align-items: center;
}

</style>
</head>
<body class="bg">

<c:url var="aboutus" value="/aboutus"></c:url>
<c:url var="indexpage" value="/logout"></c:url>
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
                <li role="presentation" class="active"><a href="">OFFERS</a></li>
                <li role="presentation" ><a style="color: #d1dbe4;" href="${aboutus}">OUR TEAM</a></li> 
            </ul>       
        </div>
    </div>
    
    <div class="container coverPhoto1" style="position: absolute; width:100%">
    
    <div class="mybox" style="height: 600px; width: 100%; text-align: center;">
        <div style="align-items: center; width: 100%;">
            <h1 style="color: rgb(255, 255, 255); font-size: 45px; font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif">OFFER ZONE</h1>
            </div>
        <img class="mySlides imgsizer" src="${pageContext.request.contextPath}/webjars/images/img1.jpg" >
        <img class="mySlides imgsizer" src="${pageContext.request.contextPath}/webjars/images/img2.jpg" >
        <img class="mySlides imgsizer" src="${pageContext.request.contextPath}/webjars/images/img3.jpg" >
        <img class="mySlides imgsizer" src="${pageContext.request.contextPath}/webjars/images/offer1.png" >
        <!-- Every image has a button using which we can move throgh slides -->
        <!-- Every button has a onclick method -->
        <div class="arrange-horizontally" style="width:100%;">
                <div class="w3-hover-white" onclick="plusDivs(-1)">&#10094;</div>
                <span>&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                <span class="mybadge demo w3-hover-white myborder" onclick="currentDiv(1)"></span> 
                <span class="mybadge demo w3-hover-white myborder" onclick="currentDiv(2)"></span>
                <span class="mybadge demo w3-hover-white myborder" onclick="currentDiv(3)"></span>
                <span class="mybadge demo w3-hover-white myborder" onclick="currentDiv(4)"></span>
                <span>&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                <div class="w3-hover-white" onclick="plusDivs(1)">&#10095;</div>
              </div>
              <!-- Slide Show function -->
              <script>
                //   intialize variable index
                var slideIndex = 1;
                //initialize with 1st image
                showDivs(slideIndex);
                
                // if user clicks on next button call showDivs and pass current index + 1
                function plusDivs(n) {
                  showDivs(slideIndex += n);
                }
                
                // if user clicks on button for specific image call and pass index of the image
                function currentDiv(n) {
                  showDivs(slideIndex = n);
                }
                
                //implementation of showDivs
                function showDivs(n) {
                  var i; //initilize variable i
                  var x = document.getElementsByClassName("mySlides"); //get reference for element with class mySlides i.e. images in slides
                  var dots = document.getElementsByClassName("demo"); //get reference for element with class demo
                  if (n > x.length) {slideIndex = 1} //when curser moves from last element it goes back to first
                  if (n < 1) {slideIndex = x.length} //when curser moves back from first element it goes to last
                  //this loops first sets display of all images to none
                  for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";  
                  }

                  //this loop removes white color of currently selected image
                  for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" w3-white", "");
                  }

                  //this command shows the image selected by user 
                  x[slideIndex-1].style.display = "block";
                  
                  //this command colors the dot for the corrosponding image to white
                  dots[slideIndex-1].className += " w3-white";

                }
                </script>
        </div>
    
    <h1 align="center">Product Offers</h1>
    <br>
      <table class="table table-bordered" style="border: 5px solid #999; width: 75%; margin-left: auto; margin-right: auto;">
         <tr>
            <th>Product</th>
            <th>Offer</th>
            <th>Due</th>
         </tr>
         <tr>
            <td>Chicken Thighs</td>
            <td>20% offer</td>
            <td>Ends 5/6/21</td>
         </tr>
         <tr>
            <td>Tomato
            </td>
            <td>Sale $1
            </td>
            <td>Ends Sunday
            </td>
         </tr>
         <tr>
            <td>Yogurt
            </td>
            <td>Sale $1.99
            </td>
            <td>Ends 5/4/21
            </td>
         </tr>
         <tr>
            <td>Green Tea
            </td>
            <td>30% Offer
            </td>
            <td>Ends 5/10/21
            </td>
         </tr>
         <tr>
            <td>Carrots
            </td>
            <td>Sale $1
            </td>
            <td>Ends Sunday
            </td>
         </tr>
         <tr>
            <td>Lamb
            </td>
            <td>25% Offer
            </td>
            <td>Ends 5/6/21
            </td>
         </tr>
         <tr>
            <td>Bread
            </td>
            <td>Sale $0.99
            </td>
            <td>Ends 5/2/21
            </td>
         </tr>
         <tr>
            <td>Shrimp
            </td>
            <td>Sale $8.99
            </td>
            <td>Ends 5/6/21
            </td>
         </tr>
         <tr>
            <td>Milk
            </td>
            <td>Sale $1.99
            </td>
            <td>Ends 5/2/21
            </td>
         </tr>
         
      </table>
    </div>

</body>
</html>