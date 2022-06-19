<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<title>Omikuji Page</title>
</head>
<body class="containter bg-secondary">
	<h1 class="text-center">Send an Omikuji!</h1>
	
	<div class="container border">
		<form action="/submit" method="POST">
			<div class="mb-3">
				<label for="num" class="form-label">Pick a number from 5 to 25:</label>
				<input type="number" name="num" value="0"/>
			</div>
			<div class="mb-3">
  				<label for="city" class="form-label">Enter the name of any city.</label>
  				<input type="text" class="form-control" name="city">
			</div>
			<div class="mb-3">
  				<label for="person" class="form-label">Enter the name of any person.</label>
  				<input type="text" class="form-control" name="person">
			</div>
			<div class="mb-3">
  				<label for="hobby" class="form-label">Enter any hobby.</label>
  				<input type="text" class="form-control" name="hobby">
			</div>
			<div class="mb-3">
  				<label for="animals" class="form-label">Enter any animal.</label>
  				<input type="text" class="form-control" name="animal">
			</div>
			<div class="mb-3">
  				<label for="message" class="form-label">Say something nice to someone:</label>
  				<input type="text" class="form-control" name="message">
			</div>
			<div class="mb-3 text-center">
				<button class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>