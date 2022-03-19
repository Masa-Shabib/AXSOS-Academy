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
    			<h2>Add a Song</h2>
    			<a href="/dashboard">Dashboard</a>
                <form:form action="/songs/new/add" method="post" modelAttribute="song">
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Title</form:label>
                        <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="artist" type="text" class="form-control" name = "artist" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="artist" for="floatingInput">Artist</form:label>
                        <form:errors path="artist" class = "my-3"  style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="rating" type="number" min="1" max="10" class="form-control" name = "rating" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="rating" for="floatingInput">Rating</form:label>
                    <form:errors path="rating" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add Song</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>