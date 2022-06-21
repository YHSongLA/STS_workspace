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
<link rel="stylesheet" href="/css/main.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container bg-secondary">
	<h1>Book Club</h1>
	<h3>A place where friends can share their thoughts on books.</h3>
	<div class="d-flex justify-content-around align-items-center mt-5">
		
		<!-- REGISTER -->
		<div class="border p-3">
			<h2>Register</h2>
			<form:form action="/register" method="POST" modelAttribute="newUser">
				<div class="row mb-3">
				    <form:label path="userName" for="userName" class="col-sm-2 col-form-label">Username</form:label>
				    <form:input path="userName" type="text" class="form-control"/>
				    <form:errors class="text-danger" path="userName"/>
				  </div>
				  <div class="row mb-3">
				    <form:label path="email" for="email" class="col-sm-2 col-form-label">Email</form:label>
				    <form:input path="email" type="email" class="form-control"/>
				    <form:errors class="text-danger" path="email"/>
				  </div>
				  <div class="row mb-3">
				    <form:label path="password" for="password" class="col-sm-2 col-form-label">Password</form:label>
				    <form:input path="password" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="password"/>
				  </div>
				  <div class="row mb-3">
				  	<form:label path="confirm" for="confirm" class="col-sm-2 col-form-label">Confirm</form:label>
				    <form:input path="confirm" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="confirm"/>
				 </div>
			  	<button type="submit" class="btn btn-primary float-end">Register</button>
			</form:form>
		</div>
		
		<!-- LOG IN -->
		<div class="border p-3">
			<h2>Login</h2>
			<form:form action="/login" method="POST" modelAttribute="newLogin">
				  <div class="row mb-3">
				    <form:label path="email" for="email" class="col-sm-2 col-form-label">Email</form:label>
				    <form:input path="email" type="email" class="form-control"/>
				    <form:errors class="text-danger" path="email"/>
				  </div>
				  <div class="row mb-3">
				    <form:label path="password" for="password" class="col-sm-2 col-form-label">Password</form:label>
				    <form:input path="password" type="password" class="form-control"/>
				    <form:errors class="text-danger" path="password"/>
				  </div>
			  	 <button type="submit" class="btn btn-primary float-end">Sign in</button>
			</form:form>
		</div>
	</div>
</body>
</html>