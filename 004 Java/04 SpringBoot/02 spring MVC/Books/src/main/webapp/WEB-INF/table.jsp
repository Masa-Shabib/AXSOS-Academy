<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<h1>All Books</h1>
                <table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">Title</th>
				      <th scope="col">Language</th>
				      <th scope="col"># Pages</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="oneBook" items="${books}">
				    <tr>
				    	<td><c:out value="${oneBook.id}"></c:out></td>
				    	<td><a href="/books/<c:out value="${oneBook.id}"></c:out>"><c:out value="${oneBook.title}"></c:out></a></td>
				        <td><c:out value="${oneBook.language}"></c:out></td>
				      	<td><c:out value="${oneBook.numberOfPages}"></c:out></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
    </div>
    </div>
    </div>
</body>
</html>