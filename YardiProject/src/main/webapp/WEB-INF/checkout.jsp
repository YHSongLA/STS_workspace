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
<title>Checkout Page</title>
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
				<a href="/home" class="btn btn-outline-warning ms-4">home</a>
				<a href="/logout" class="btn btn-outline-warning ms-2">logout</a>
			</div>
		</div>
	</header>
	
	<div class="container mt-5 shadow p-3 mb-5 bg-body rounded d-flex justify-content-between align-items-center">
		<div class="billing border border-secondary rounded w-50 p-3">
			<form class="row g-3">
			  <div class="col-md-6">
			    <label for="inputEmail4" class="form-label">Email</label>
			    <input type="email" class="form-control" id="inputEmail4">
			  </div>
			  <div class="col-md-6">
			    <label for="inputPassword4" class="form-label">Password</label>
			    <input type="password" class="form-control" id="inputPassword4">
			  </div>
			  <div class="col-12">
			    <label for="inputAddress" class="form-label">Address</label>
			    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
			  </div>
			  <div class="col-12">
			    <label for="inputAddress2" class="form-label">Address 2</label>
			    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
			  </div>
			  <div class="col-md-6">
			    <label for="inputCity" class="form-label">City</label>
			    <input type="text" class="form-control" id="inputCity">
			  </div>
			  <div class="col-md-4">
			    <label for="inputState" class="form-label">State</label>
			    <select id="inputState" class="form-select">
			      <option selected>Choose...</option>
			      <option>...</option>
			    </select>
			  </div>
			  <div class="col-md-2">
			    <label for="inputZip" class="form-label">Zip</label>
			    <input type="text" class="form-control" id="inputZip">
			  </div>
			  <div class="col-12">
			    <button type="submit" class="btn btn-outline-primary w-100">Submit</button>
			  </div>
			</form>
		</div>
		
		<div class="checkoutbox border border-secondary rounded w-25 p-3">
			<p>Total:</p>
			<a href="/purchase/order" class="btn btn-outline-success">purchase</a>
		</div>
	</div>
	<script src="/script/main.js"></script>
</body>
</html>