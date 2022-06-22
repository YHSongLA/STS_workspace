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
	<h1>Welcome, <c:out value="${user.firstName}"/>!</h1>
	<div class="d-flex justify-content-between align-items-center">
		<p>All Projects</p>
		<a href="/new/project">+ new project</a>
		<a href="/logout" class="btn btn-outline-danger mx-2">LOGOUT</a>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Due Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${projects}">
				<tr>
					<td><c:out value="${project.id}"/></td>
					<td><a href="/project/${project.id}"><c:out value="${project.title}"/></a></td>
					<td><c:out value="${project.dueDate}"/></td>
					<td>Join</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>