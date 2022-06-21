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
	<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
	<div>
		<p>Books from everyone's shelves.</p>
		<a href="/new/book">Add a book!</a>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="/book/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.creator.userName}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- LOG OUT -->
	<a href="/logout" type="btn btn-outline-danger mx-2">LOGOUT</a>
</body>
</html>