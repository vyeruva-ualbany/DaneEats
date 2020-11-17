<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    background: url("ualbny.jpg") no-repeat center center fixed;
    background-size: cover
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

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
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

input[type=text]{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=password]{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
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

.division {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

	<div class="topnav" id="myTopnav">
        <a href="#home" class="active">DaneEats</a>
        <a href="ViewOrders.jsp">Home</a>
  <div class="dropdown">
    <button class="dropbtn">About 
      <i class="fa fa-caret-down"></i>
    </button>
        <div class="dropdown-content">
        <a href="DeliveryProfile.jsp">Profile</a>
        <a href="#">Payments</a>
        <a href="home.jsp">Logout</a>
        </div>
   </div>
    <div class="dropdown">
    <button class="dropbtn">Orders 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="${contextPath}/delivery/availableorders">Available Orders</a>
  	  <a href="${contextPath}/delivery/currentorders">Current Orders</a>
      <a href="${contextPath}/delivery/previousordersd">Previous Orders</a>
    </div>
  </div> 
  </div>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="updateUsername.jsp">Update Information</a>
  <a href="changePassD.jsp">Change Password</a>
  <a href="#">Unsubscribe</a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
<center>
<br><br><br><center>
<div id="division">
  <form method="POST" id="my-form" action="#" onsubmit="return update(this)" class="form-signin">
        <h2 class="form-heading">change password</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <label for="username">Enter Username</label>
            <input type="text" id="username" name="username"><br><br><br>
    		<label for="pwd2">Enter New Password</label>
   			 <input type="password" id="pwd2" name="pwd2"><br><br><br>
            <label for="pwd3">confirm New Password</label>
   			 <input type="password" id="pwd3" name="pwd3"><br><br><br>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Update Information</button>
           
        </div>
      </form>
</div>
<p id="demo"></p>
<p id="demo1"></p>
<script>
var update = function(button)
{
	 var inputs = document.getElementById("my-form").elements;
	 var username=inputs["username"];
	 var new_pass = inputs["pwd2"];
	 var confirm_pass = inputs["pwd3"];
	 document.getElementById("demo").innerHTML = new_pass;
	 document.getElementById("demo1").innerHTML = confirm_pass;
	 if(new_pass === confirm_pass){
	 let user = {};
	 user["username"]= username;
	 user["password"] = new_pass;
	 user["confirm_pass"] = confirm_pass;
	 let requestURL = "/api/user/updatepass";
	 let request = new XMLHttpRequest();
	 request.open('POST', requestURL); 
	 request.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    request.responseType = 'json';
	 request.send(JSON.stringify(order));
	 request.onload = function(){
		 const reportdatajson = request.response;
		 if(reportdatajson.status == "Done"){
			 alert("Success");
		 }
		 else{
			 alert("Error"); 
		 }
	 }	
}
	 else{
		 alert("Passwords do not match.Try again");
		 }
	 }
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
