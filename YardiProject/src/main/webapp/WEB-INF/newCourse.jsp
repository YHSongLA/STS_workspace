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
<body class="bg-secondary">
	<header class="bg-dark p-4 shadow p-3 mb-5 bg-body rounded">
		<div class="container bg-secondary d-flex justify-content-between align-items-center p-2 rounded">
			<h3 class="text-warning">Yardi Courses</h3>
			<form class="d-flex" role="search" action="/searched" method="POST">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searched" id="searched">
                <button class="btn btn-outline-warning" type="submit">Search</button>
            </form>
            <div>
				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart4 text-warning" viewBox="0 0 16 16">
  					<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
				</svg>
				<a href="/home" class="btn btn-outline-warning ms-4">home</a>
				<a href="/logout" class="btn btn-outline-warning ms-2">logout</a>
			</div>
		</div>
	</header>
	
	<div class="container mt-5 shadow p-3 mb-5 bg-body rounded">
		<form:form action="/create/course" method="POST" modelAttribute="courseObj">
			
			<div class="mb-3">
  				<form:label class="form-label" path="name">Name:</form:label>
  				<form:input type="text" class="form-control" path="name"/>
  				<form:errors path="name"/>
			</div>
			<div class="mb-3">
  				<form:label class="form-label" path="content">Content:</form:label>
  				<form:input type="text" class="form-control" path="content"/>
  				<form:errors path="content"/>
			</div>
			<div class="mb-3">
  				<form:label class="form-label" path="price">Price:</form:label>
  				<form:input type="number" class="form-control" path="price"/>
  				<form:errors path="price"/>
			</div>
			<div class="mb-3">
  				<form:label class="form-label" path="description">Description:</form:label>
  				<form:input type="text" class="form-control" path="description"/>
  				<form:errors path="description"/>
			</div>
			<div class="mb-3 text-center">
				<a href="/account/${user_id}" class="btn btn-danger">Cancel</a>
				<button class="btn btn-success" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>