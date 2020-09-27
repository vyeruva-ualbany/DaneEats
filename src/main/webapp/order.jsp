<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#menu {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#menu td, #menu th {
  border: 1px solid #ddd;
  padding: 8px;
}

#menu tr:nth-child(even){background-color: #f2f2f2;}

#menu tr:hover {background-color: #ddd;}

#menu th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
* {
  box-sizing: border-box;
}
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
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
header {
  background-color: #b2c5fa;
  padding: 20px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #e4eafc ;
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}
@media (max-width: 600px) {
  article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>
<header>
<center><h1>UALBANY DANEATS</h1></center>
</header>
<div class="navbar">
  <a href="intro.jsp">Home</a>
  <a href="order.jsp">Order</a>
  <a href="#news">Support</a>
  <div class="dropdown">
    <button class="dropbtn">About 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="CustomerProfile.jsp">Profile</a>
      <a href="#">Orders</a>
      <a href="#">Addresses</a>
      <a href="#">Payments</a>
      <a href="home.jsp">Logout</a>
    </div>
  </div> 
</div>
  <center>
    <table id="menu">
    <tr>
    <th><center>Restaurant</th>
    <th><center>Service Hours</th>
    <th><center>Rating</th>
    <th><center>Delivery time</th>
    <th></th>
    </tr>
    <tr>
    <td><center><img src="starbucks.jpg" height=100 width=100></center></td>
    <td><center>10:00 AM - 8:00 PM</td>
    <td><center><h2>****</h2></td>
    <td><center>15-20 mins</td>
    <td><center><form action="cart.html"><input type="submit" value="order"></form></td>
    </tr>
    <tr>
    <td><center><img src="mcd.png" height=100 width=100></center></td>
    <td><center>10:00 AM - 11:00 PM</td>
    <td><center><h2>***</h2></td>
    <td><center>25-30 mins</td>
    <td><center><form action="cart.html"><input type="submit" value="order"></form></td>
    </tr>
    <tr>
    <td><center><img src="pizza.png" height=100 width=100></center></td>
    <td><center>11:00 AM - 7:00 PM</td>
    <td><center><h2>*****</h2></td>
    <td><center>10-15 mins</td>
    <td><center><form action="cart.html"><input type="submit" value="order"></form></td>
    </tr>
    <tr>
    <td><center><img src="bk.png" height=100 width=100></center></td>
    <td><center>10:00 AM - 10:00 PM</td>
    <td><center><h2>**</h2></td>
    <td><center>30-40 mins</td>
    <td><center><form action="cart.html"><input type="submit" value="order"></form></td>
    </tr>
    <tr>
    <td><center><img src="dunkin.png" height=100 width=100></center></td>
    <td><center>8:00 AM - 8:00 PM</td>
    <td><center><h2>***</h2></td>
    <td><center>15-20 mins</td>
    <td><center><form action="cart.html"><input type="submit" value="order"></form></td>
    </tr>
    </table>
    </center>
<script>
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
    document.getElementById("header").style.fontSize = "30px";
  } else {
    document.getElementById("header").style.fontSize = "90px";
  }
}
</script>
</body>
</html>
