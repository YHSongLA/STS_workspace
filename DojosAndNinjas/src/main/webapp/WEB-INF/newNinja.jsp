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
	<h1>New Ninja</h1>
	<form:form action="/create/ninja" method="POST" modelAttribute="ninjaObj">
		<p>
			Locations:
			<form:select path="locations">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<div class="row mb-3">
			<form:label class="col-sm-2 col-form-label" path="firstName">First Name:</form:label>
		    <form:input type="text" class="form-control" path="firstName"/>
		</div>
		<div class="row mb-3">
			<form:label class="col-sm-2 col-form-label" path="lastName">Last Name:</form:label>
		    <form:input type="text" class="form-control" path="lastName"/>
		</div>
		<div class="row mb-3">
			<form:label class="col-sm-2 col-form-label" path="age">Age:</form:label>
		    <form:input type="number" class="form-control" path="age"/>
		</div>
		<button type="submit" class="btn btn-primary">Create</button>
	</form:form>
</body>
</html>