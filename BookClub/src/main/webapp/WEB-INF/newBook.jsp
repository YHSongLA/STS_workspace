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
	<div class="bg-sucess">
		<form:form action="/create/book" method="POST" modelAttribute="bookObj">
			<form:input path="creator" type="hidden" value="${user_id}"/>
			<div class="mb-3">
  				<form:label for="title" class="form-label" path="title">Title:</form:label>
  				<form:input type="text" class="form-control" path="title"/>
  				<form:errors path="title"/>
			</div>
			<div class="mb-3">
  				<form:label for="author" class="form-label" path="author">Author:</form:label>
  				<form:input type="text" class="form-control" path="author"/>
  				<form:errors path="author"/>
			</div>
			<div class="mb-3">
  				<form:label for="thoughts" class="form-label" path="thoughts">Your Thoughts:</form:label>
  				<form:input type="text" class="form-control" path="thoughts"/>
  				<form:errors path="thoughts"/>
			</div>
			<div class="mb-3 text-center">
				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>