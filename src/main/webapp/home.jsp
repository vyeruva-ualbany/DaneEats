	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
		body {
    background: url(https://livewallpaperhd.com/wp-content/uploads/2020/09/Wallpaper-HD-Food.jpg) no-repeat center center fixed;
    background-size: cover
	}
    .container {
    width: 100%;
    padding-top: 50px;
    padding-bottom: 100px
}

.frame {
    background: #60E9F4
    background-size: cover;
    margin-left: auto;
    margin-right: auto;
    border-radius: 5px;
   
    overflow: hidden;
    transition: all .5s ease
}
.topnav {
  background-color: #020000;
  overflow: hidden;
}


.topnav a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}


.topnav a:hover {
  background-color: #373434;
  color: black;
}

.topnav a.active {
  background-color: #2E2B2B;
  color: white;
}

.topnav .topnavright{
float: right;
}

.navbar-logo
{
float:left
}

.container-table {
    height: 100%;
}
.container-table {
    display: table;
}
.vertical-center-row {
    display: table-cell;
    vertical-align: middle;
}

* {
  box-sizing: border-box;
}

.row::after {
  content: "";
  clear: both;
  display: table;
}

[class*="col-"] {
  float: left;
  padding: 15px;
}
html {
  font-family: "Lucida Sans", sans-serif;
}


.aside {
  background-color: #FC3B3B;
  padding: 15px;
  color: #020000;
  text-align: center;
  font-size: 14px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}


.footer {
  background-color: #020000;
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 8px;
}
[class*="col-"] {
  width: 100%;
}
@media only screen and (min-width: 600px) {
  /* For tablets: */
  .col-s-1 {width: 8.33%;}
  .col-s-2 {width: 16.66%;}
  .col-s-3 {width: 25%;}
  .col-s-4 {width: 33.33%;}
  .col-s-5 {width: 41.66%;}
  .col-s-6 {width: 50%;}
  .col-s-7 {width: 58.33%;}
  .col-s-8 {width: 66.66%;}
  .col-s-9 {width: 75%;}
  .col-s-10 {width: 83.33%;}
  .col-s-11 {width: 91.66%;}
  .col-s-12 {width: 100%;}
}
@media only screen and (min-width: 768px) {
  /* For desktop: */
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 25%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}
}

</style>
</head>
<body>
	<div class="topnav" id="myTopnav">
        <div class="navbar-logo">
                <img src="https://cdn.dribbble.com/users/1365713/screenshots/5381232/foodiction.png" alt="Test" height="53" width="80" />
        </div>
        <a href="#home" class="active">DaneEats</a>
        <a class ="topnavright" href="${contextPath}/register">SignUp</a>
        <a class ="topnavright" href="${contextPath}/login">Login</a>
        <a class ="topnavright" href="">Admin</a>
    </div>
<div class="row">
  
 <div class="col-3 col-s-12">
    <div class="aside">
      <h3>In an instant?</h3>
      <p class="font-italic">Pizza, coffee, and cheesecake—all in 30 minutes? Done.</p>
      <h3>Explore?</h3>
      <p class="font-italic">Making new meaning out of holidays with Sweet & savory snacks.</p>
      <h3>Recipes We Love</h3>
      <p class="font-italic">Find all the popular items,<a href="" target="_blank">Here!</a></p>
    </div>
  </div>
  
   <div class="col-6 col-s-9">
 <div class="container">
 <div class="frame">
        <h2 style="color:white;">Clean Eating.</h2>
        <h2 style="color:white;">No Sacrificies.</h2>
        <p class="lead" style="color:white;">  Food on a campus shouldn't mean canned beans and ramen noodles night after night. Instant delivery any time? You bet, with <a href="" target="_blank">DaneEats</a> food delivery service.</p>
        <p><a href="" target="_blank" class="btn btn-success btn-lg">Order Now</a></p>
    </div>
    </div>
    </div>
</div>

  

	
    <div class="footer fixed-bottom">
    <p>DaneEats@Ualbany</p>
    </div>


</body>
</html>
