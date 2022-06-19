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
<title>Insert title here</title>
</head>
<body class="container bg-dark">
	<h1 class="text-center text-light">Your Book!</h1>
	<div class="card" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${book.title}"/></h5>
	    <p class="card-text">Description: <c:out value="${book.description}"/></p>
	    <p class="card-text">Language: <c:out value="${book.language}"/></p>
	    <p class="card-text">Number of pages: <c:out value="${book.numberOfPages}"/></p>
	  </div>
	</div>
</body>
</html>