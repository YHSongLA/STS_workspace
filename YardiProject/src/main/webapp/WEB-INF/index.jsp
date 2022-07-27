<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Login And Register</title>
</head>
<body class="bg-secondary">
	<header class="bg-dark p-4 shadow p-3 mb-5 bg-body rounded">
		<div class="container bg-secondary d-flex justify-content-between align-items-center p-2 rounded">
			<h3 class="text-warning">Yardi Courses</h3>
			<form class="d-flex" role="search" action="/searched" method="POST">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searched" id="searched">
                <button class="btn btn-outline-warning" type="submit">Search</button>
            </form>
            <div>
				<a href="/carts">
	            	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart4 text-warning" viewBox="0 0 16 16">
	  					<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
					</svg>
				</a>
				<button type="button" class="login_open btn btn-outline-warning ms-4" onclick="loginToggle()">login</button>
                <button type="button" class="regis_open btn btn-outline-warning ms-2" onclick="regisToggle()">signup</button>
			</div>
		</div>
	</header>
	
	<div class="container d-flex justify-content-around align-items-center mt-5 shadow p-3 mb-5 bg-body rounded">
		
		<!-- REGISTER -->
		<div class="border p-3 bg-secondary shadow p-3 rounded text-center">
			<h2 class=" border-bottom p-1">Register</h2>
			<form:form action="/register" method="POST" modelAttribute="newUser">
				<div class="row mb-3">
				    <form:label path="firstName" class="col-sm-2 col-form-label">First Name:</form:label>
				    <form:input path="firstName" type="text" class="form-control"/>
				    <form:errors class="text-danger" path="firstName"/>
				</div>
				<div class="row mb-3">
				    <form:label path="lastName" class="col-sm-2 col-form-label">Last Name:</form:label>
				    <form:input path="lastName" type="text" class="form-control"/>
				    <form:errors class="text-danger" path="lastName"/>
				</div>
				  <div class="row mb-3">
				    <form:label path="email" for="email" class="col-sm-2 col-form-label">Email:</form:label>
				    <form:input path="email" type="email" class="form-control"/>
				    <form:errors class="text-danger" path="email"/>
				  </div>
				  <div class="row mb-3">
				    <form:label path="password" for="password" class="col-sm-2 col-form-label">Password:</form:label>
				    <form:input path="password" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="password"/>
				  </div>
				  <div class="row mb-3">
				  	<form:label path="confirm" for="confirm" class="col-sm-2 col-form-label">Confirm:</form:label>
				    <form:input path="confirm" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="confirm"/>
				 </div>
			  	<button type="submit" class="btn btn-primary w-100">sign up</button>
			</form:form>
		</div>
		
		<!-- LOG IN -->
		<div class=" border p-3 bg-secondary shadow p-3 rounded text-center">
			<h2 class="border-bottom p-1">Login</h2>
			<form:form action="/login" method="POST" modelAttribute="newLogin">
				  <div class="row mb-3">
				    <form:label path="email" for="email" class="col-sm-2 col-form-label">Email:</form:label>
				    <form:input path="email" type="email" class="form-control"/>
				    <form:errors class="text-danger" path="email"/>
				  </div>
				  <div class="row mb-3">
				    <form:label path="password" for="password" class="col-sm-2 col-form-label">Password:</form:label>
				    <form:input path="password" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="password"/>
				  </div>
			  	 <button type="submit" class="btn btn-primary w-100">login</button>
			</form:form>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script src="/script/main.js"></script>
</body>
</html>