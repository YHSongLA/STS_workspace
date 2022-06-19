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
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body class="bg-dark container">
	<h1 class="text-center text-light">Submit a Book!</h1>
	<div class="container bg-success">
		<form action="/submit" method="POST">
			<div class="mb-3">
  				<label for="title" class="form-label">Enter Title:</label>
  				<input type="text" class="form-control" name="title">
			</div>
			<div class="mb-3">
  				<label for="desc" class="form-label">Enter Description:</label>
  				<input type="text" class="form-control" name="desc">
			</div>
			<div class="mb-3">
  				<label for="lang" class="form-label">Enter Language:</label>
  				<input type="text" class="form-control" name="lang">
			</div>
			<div class="mb-3">
				<label for="numOfPages" class="form-label">Enter number of pages:</label>
				<input type="number" name="pages" value="0"/>
			</div>
			<div class="mb-3 text-center">
				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>