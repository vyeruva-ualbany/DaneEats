<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
    background: url(https://livewallpaperhd.com/wp-content/uploads/2020/09/Wallpaper-HD-Food.jpg) no-repeat center center fixed;
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

table {
	background-color : white;
}
h1{
	color : white;
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
	background-color: #F9F9F9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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
html {
  font-family: "Lucida Sans", sans-serif;
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
table, th, td ,tr{
	border: 2px solid black;
	border-collapse: collapse;
	padding: 15px;
	text-align: left;
	border-spacing: 5px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}


input[type=submit] {
	background-color: #45A049;
	color: green;
	padding: 8px 10px;
	margin: 4px 0;
	border: none;
	border-radius: 2px;
	cursor: pointer;
}

.heading { color: #FF0000; }

</style>
</head>
<body>
	
	<div class="topnav" id="myTopnav">
              <a href="#home" class="active">DaneEats</a>
        <a href="ViewOrders.jsp">Home</a>
		<div class="dropdown">
			<button class="dropbtn">
				About <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="${contextPath}/profile">Profile</a> <a href="#">Payments</a> <a
					href="home.jsp">Logout</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Orders <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<center>
					<a href="${contextPath}/delivery/availableorders">Available Orders</a>
					  <a href="${contextPath}/delivery/claimedorders">Claimed Orders</a>
					   <a href="${contextPath}/delivery/currentorders">Ongoing Orders</a>
					   <a href="${contextPath}/delivery/previousordersd">Previous Orders</a>
				</center>

			</div>
		</div>
	</div>
	<br>
	<br>
	<h1 align="center" class="heading">ONGOING ORDERS</h1>
	<div align="center">
		<table id="ordertable" border="1" cellpadding="5">
			<tr>
				<th>OrderId</th>
				<th>AgentId</th>
				<th>Amount</th>
				<th>Source</th>
				<th>Menu Items</th>
				<th>Phone Number</th>
				<th>Destination</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<c:forEach var="order" items="${Oorders}">
				<tr>
					<td><c:out value="${order.id}" /></td>
					<td><c:out value="${order.agent.id}" /></td>
					<td><fmt:formatNumber value ="${order.amount}" type = "currency"/></td>
					<td><c:out value="${order.source}" /></td>
					<td><c:out value="${order.items}"/></td>
					<td><c:out value="${order.phoneNumber}"/></td>
					<td><c:out value="${order.destination}" /></td>
					<td><c:out value="${order.status}" /></td>
					<td><button id="btn-accept" class="button"
							onclick="confirm(this)">Confirm Pickup</button> <br />
						<button id="btn-decline" class="button" onclick="delivery(this)">Confirm Delivery</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	<script>
	 var confirm = function(button)
	 {
		 var id = button.parentElement.parentElement.firstElementChild.innerHTML;
		 var status = button.parentElement.previousElementSibling.innerHTML;
		 let order = {};
		 order["id"] = id;
		 order["agentId"] = 1;
		 let request = new XMLHttpRequest();
		 request.open('POST', "/api/delivery/pickuporder"); 
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
	 
	 var delivery = function(button)
	 {
		 var id =  button.parentElement.parentElement.firstElementChild.innerHTML;
		 let order = {};
		 order["id"] = id;
		 order["agentId"] = 1;
		 let requestURL = "/api/delivery/declineorder";
		 let request = new XMLHttpRequest();
		 request.open('POST', "/api/delivery/deliverorder"); 
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
	 </script>
</body>
</html>
