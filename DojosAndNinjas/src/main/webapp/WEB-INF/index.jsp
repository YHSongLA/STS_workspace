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
	<h1>New Dojo</h1>
	<div>
		<form:form action="/new/dojo" method="POST" modelAttribute="dojoObj">
		  <div class="row mb-3">
		    <form:label class="col-sm-2 col-form-label" path="name">Dojo Name:</form:label>
		    <form:input type="text" class="form-control" path="name"/>
		  </div>
		  <button type="submit" class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>