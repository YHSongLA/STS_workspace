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
	<h1>Safe Travels</h1>
	<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="i" items="${safeTravels}">
	    <tr>
	    	<td>
				<c:out value="${i.name}"/>
			</td>
			<td>
				<c:out value="${i.vendor}"/>
			</td>
			<td>
				$<c:out value="${i.amount}"/>
			</td>
			<td>
				<a href="/edit/${i.id}">Edit |</a>
				<a href="/destroy/${i.id}"> Delete</a>
			</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>

<div class="container bg-info mt-5 w-25">
		<form:form action="/create/data" method="POST" modelAttribute="safeTravelObj">
			<div class="mb-3">
  				<form:label class="form-label" path="name">Expense Name:</form:label>
  				<form:input type="text" class="form-control" path="name"/>
  				<form:errors path="name" />
			</div>
			<div class="mb-3">
  				<form:label class="form-label" path="vendor">Enter Vendor:</form:label>
  				<form:input type="text" class="form-control" path="vendor"/>
  				<form:errors path="vendor" />
			</div>
			<div class="mb-3">
  				<form:label class="form-label" path="amount">Enter Amount:</form:label>
  				<form:input type="number" class="form-control" value="0" path="amount"/>
  				<form:errors path="amount" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Enter Description:</form:label>
				<form:input type="text" path="description"/>
				<form:errors path="description" />
			</div>
			<div class="mb-3 text-center">
				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>