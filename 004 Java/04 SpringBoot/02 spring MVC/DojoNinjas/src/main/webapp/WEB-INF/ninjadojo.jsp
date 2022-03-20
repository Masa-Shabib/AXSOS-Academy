<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container-md-fluid m-5 p-5">
        <div class = "row justify-content-center">
            <div class = "col-5 align-self-center">
				<h1><c:out value="${dojo.name} "></c:out> Location Ninjas</h1>
				<a href="/dojos">Go Back</a>
                <table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Age</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="ninja" items="${ninjas}">
				    <tr>
				        <td><c:out value="${ninja.firstName}"></c:out></td>
				    	<td><c:out value="${ninja.lastName}"></c:out></td>
				    	<td><c:out value="${ninja.age}"></c:out></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
    </div>
    </div>

    </div>
    		
</body>
</html>