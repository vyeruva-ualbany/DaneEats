<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    .container {
    width: 100%;
    padding-top: 50px;
    padding-bottom: 100px
}
table {
	background-color : white;
}
h1{
	color : white;
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


.header {
  background-color: #C70039;
  color: #ffffff;
  padding: 15px;
}

.menu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.menu li {
  padding: 8px;
  margin-bottom: 7px;
  background-color: #FC3B3B;
  color: #020000;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu li:hover {
  background-color: #ffffff;
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
    </div>
    <div class="header">
</div>
	<h1 align="center" class="heading">ALL ORDERS</h1>
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
			<c:forEach var="order" items="${Corders}">
				<tr>
					<td><c:out value="${order.id}" /></td>
					<td><c:out value="${order.agent.id}" /></td>
					<td><c:out value="${order.amount}" /></td>
					<td><c:out value="${order.source}" /></td>
					<td><c:out value="${order.items}"/></td>
					<td><c:out value="${order.phoneNumber}"/></td>
					<td><c:out value="${order.destination}" /></td>
					<td><c:out value="${order.status}" /></td>
					<td><button id="btn-decline" class="button" onclick="deleteorder(this)">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	<script>
	 var deleteorder = function(button)
	 {
		 var id =  button.parentElement.parentElement.firstElementChild.innerHTML;
		 let order = {};
		 order["id"] = id;
		 order["agentId"] = 1;//userId;
		 let requestURL = "/api/delivery/cancelorder";
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
	 </script>
</body>
</html>
