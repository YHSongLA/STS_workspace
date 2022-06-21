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
	<div class="d-flex justify-content-between align-items-center">
		<h1><c:out value="${book.title}"/></h1>
		<a href="/home">Go Home</a>
	</div>
	<h4>
		<c:choose>
			<c:when test="${book.creator.id == user_id}">
				You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>
			</c:when>
			<c:otherwise>
				<c:out value="${book.creator.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>
			</c:otherwise>
		</c:choose>
	</h4>
	<div>
		<p>
			<c:choose>
				<c:when test="${book.creator.id == user_id}">
					Here are your thoughts
				</c:when>
				<c:otherwise>
					Here are <c:out value="${book.creator.userName}"/>'s thoughts
				</c:otherwise>
			</c:choose>
		</p>
		<p><c:out value="${book.thoughts}"/></p>
	</div>
	<a href="/edit/book/${book.id}">Edit</a>
</body>
</html>