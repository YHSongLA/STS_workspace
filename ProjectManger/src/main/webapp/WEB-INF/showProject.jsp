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
		<h1><c:out value="${project.title}"/></h1>
		<a href="/home">Go Home</a>
	</div>
	<p>Project: <c:out value="${project.title}"/></p>
	<p>Description: <c:out value="${project.description}"/></p>
	<p>Due Date: <c:out value="${project.dueDate}"/></p>
	<div class="d-flex justify-content-between align-items-center">
		<a href="/edit/project/${project.id}">Edit</a>
		<a href="/destroy/${project.id}" class="btn btn-outline-danger mx-2">Delete</a>
	</div>
</body>
</html>