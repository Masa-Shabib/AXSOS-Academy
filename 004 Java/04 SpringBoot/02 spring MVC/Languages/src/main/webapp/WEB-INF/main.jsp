<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
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
				<h1>All Languages</h1>
                <table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Creator</th>
				      <th scope="col">Version</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="lang" items="${languages}">
				    <tr>
				    	<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"></c:out></a></td>
				        <td><c:out value="${lang.creator}"></c:out></td>
				      	<td><c:out value="${lang.version}"></c:out></td>
				      	<td><a href="/languages/${lang.id}/edit">Edit</a>
				      	<form action="/languages/${lang.id}/delete" method="post">
				      	<input type="hidden" name="_method" value="delete">
				      	<button type="submit" class="btn btn-info ">Delete</button></form></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
    </div>
    </div>
    <div class = "row justify-content-center">
            <div class = "col-5 align-self-center">
    			<h2>Add an Language</h2>
                <form:form action="/languages/create" method="post" modelAttribute="language">
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Expense Name</form:label>
                        <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="creator" type="text" class="form-control" name = "creator" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="creator" for="floatingInput">Creator</form:label>
                        <form:errors path="creator" class = "my-3"  style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="version" type="text" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="version" for="floatingInput">Version</form:label>
                    <form:errors path="version" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>