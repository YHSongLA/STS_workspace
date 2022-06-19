
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<title>Index Page</title>
</head>

<body class="container bg-light text-primary">
	<h1>Fruity Loop</h1>
	
	<table class="table table-dark table-striped text-info">
		<thead>
			<th>Name</th>
			<th>Price</th>
		</thead>
		
		<tbody>
			<c:forEach var="i" items="${allFruits}">
			<tr>
				<td>
					<c:out value="${i.getName()}"/>
				</td>
				<td>
					<c:out value="${i.getPrice()}"/>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>