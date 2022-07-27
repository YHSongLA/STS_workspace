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
<title>Home Page</title>
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
				<c:choose>
					<c:when test="${not empty user_id}">
						<a href="/account/${user_id}" class="btn btn-outline-warning ms-4">Account</a>
						<a href="/logout" class="btn btn-outline-warning ms-2">logout</a>
					</c:when>
					<c:otherwise>
						<a href="/" class="btn btn-outline-warning ms-4">login</a>
						<a href="/" class="btn btn-outline-warning ms-2">signup</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>
	<div class="container mt-5 shadow p-3 mb-5 bg-body rounded">
		<div class="text-center shadow">
			<video autoplay muted loop id="myVideo" class="w-50 mb-3">
		        <source src="/vids/pexels-cottonbro-8468477.mp4" type="video/mp4">
		    </video>
	    </div>
	    <div class="mt-5">
	    	<h3>What to learn next</h3>
	    	<div class="d-flex justify-content-between align-items-center mt-5">
	    		<c:forEach var="course" items="${courses}">
		    		<div class="card border border-secondary" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title"><c:out value="${course.name}"/></h5>
					    <h6 class="card-subtitle mb-2 text-muted"><c:out value="${course.content}"/></h6>
					    <p class="card-text"><c:out value="${course.price}"/></p>
					    <p class="card-text"><c:out value="${course.description}"/></p>
					    <form action="/carts" method="POST">
					    	<input type="hidden" name="course_id" value="${course.id }" />
					    	<button class="btn btn-outline-warning w-100">Add to Cart</button>
					    </form>
					  </div>
					</div>
	    		</c:forEach>
	    	</div>
	    </div>
    </div>
    <script src="/script/main.js"></script>
</body>
</html>