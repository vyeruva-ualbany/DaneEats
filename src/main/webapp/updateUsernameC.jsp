<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
table {
	background-color : white;
}
h1{
	color : white;
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
.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}




input[type=submit] {
  width: 10%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

 .heading { color: #FFFFFF; }
</style>
</head>
<body>

	<div class="topnav" id="myTopnav">
        <a href="#home" class="active">DaneEats</a>
        <a href="${contextPath}/customer/profile">Back</a>
  <div class="dropdown">
    <button class="dropbtn">About 
      <i class="fa fa-caret-down"></i>
    </button>
        <div class="dropdown-content">
        <a href="${contextPath}/customer/profile">Profile</a>
        <a href="#">Payments</a>
        <a href="home.jsp">Logout</a>
        </div>
   </div>
  </div>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="${contextpath}/customer/updateusername">Update Information</a>
  <a href="${contextpath}/customer/changepassword">Change Password</a>
  <a href="#">Unsubscribe</a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
<center>
<br><br><br><center>
<div class="container">
 <div class="frame">
<div id="division">
  <form method="POST" id="my-form" action="#" class="form-signin">
        <h2 class="heading">Change Username</h2>
        <div>
            <label class="heading" for="username">Enter Username</label>
            <input type="text" id="username" name="username"><br><br><br>
    		<label  class="heading" for="username1">New Username</label>
   			 <input type="text" id="username1" name="username1"><br><br><br>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
           
        </div>
      </form>
</div>
</div>
</div>
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
</body>
</html>
