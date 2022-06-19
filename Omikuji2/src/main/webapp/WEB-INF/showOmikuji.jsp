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
<title>Insert title here</title>
</head>
<body class="container text-center m-auto">
	<h1 class="text-center">Here's Your Omikuji!</h1>
	
	<div class="card text-bg-primary mb-3" style="max-width: 18rem;">
  		<div class="card-body">
    		<p class="card-text">In <c:out value="${num}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, selling <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${animal}"/>, you will have good luck. Also, <c:out value="${message}"/>.</p>
  		</div>
  	</div>
</body>
</html>