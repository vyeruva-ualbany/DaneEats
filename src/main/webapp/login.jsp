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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<style>
		body {
    background: url("ualbny.jpg") no-repeat center center fixed;
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
}</style></head>
<body>
<div class="topnav" id="myTopnav">
        <div class="navbar-logo">
                <img src="https://cdn.dribbble.com/users/1365713/screenshots/5381232/foodiction.png" alt="Test" height="53" width="80" />
        </div>
        <a href="#home" class="active">DaneEats</a>
        <a href="${contextPath}/home">Back to Home</a>
        <a class ="topnavright" href="">SignUp</a>
    </div>
    <div class="maincontent">
	    <section id="">
			<div class="item row align-items-center">
              <div class="col-sm-6">
			    <div class="container">
			    <div class="frame">
				  <img class="rounded mx-auto d-block" src="https://www.intellicom-analytics.com/images/avatar.png" >
				   <div class="nav">
        </div>
			      <form:form method="POST" action="${contextPath}/Customer-login"
			modelAttribute="userForm" class="form-signin marg-login">
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>



			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>


			<input type="hidden" name="${_csrf.parameterName}"
				action="${contextPath}/login" value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				In</button>
			<h4 class="text-center">
				<a href="${contextPath}/register">Create an account</a>
			</h4>
		</form:form>
		</div>
			    </div>
              </div>
              <div class="col-sm-6">	
			    <div class="container">
			    <div class="frame">
			      <img class="rounded mx-auto d-block" src="${pageContext.request.contextPath}/resources/img/dicon.png">
			      <form:form method="POST" action="${contextPath}/Delivery-login"
			modelAttribute="userForm" class="form-signin marg-login">
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>



			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>


			<input type="hidden" name="${_csrf.parameterName}"
				action="${contextPath}/login" value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				In</button>
			<h4 class="text-center">
				<a href="${contextPath}/register">Create an account</a>
			</h4>
		</form:form>

			    </div>
              </div>  
			</div>
        </section>
    </div>
    
    
    <div class="footer fixed-bottom">
    <p>DaneEats@Ualbany</p>
    </div>
    
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
