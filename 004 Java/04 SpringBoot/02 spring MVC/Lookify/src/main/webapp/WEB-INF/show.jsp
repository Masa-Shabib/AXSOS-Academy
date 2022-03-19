<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
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
            	<h1 >Song Details</h1><a href="/dashboard">Dashboard</a>
                <h3 class = "mb-3"><strong>Title:</strong> <c:out value="${song.name}"/></h3>
                <p style = "font-size: 20px;"><strong>Artist:</strong> <c:out value="${song.artist}"/></p>
                <p style = "font-size: 20px;"><strong>Rating:</strong> <c:out value="${song.rating}"/></p>
                <form action="/songs/${song.id}/delete" method="post">
				      	<input type="hidden" name="_method" value="delete">
				      	<button type="submit" class="btn btn-info ">Delete</button></form>
            </div>
        </div>
    </div>	
</body>
</html>