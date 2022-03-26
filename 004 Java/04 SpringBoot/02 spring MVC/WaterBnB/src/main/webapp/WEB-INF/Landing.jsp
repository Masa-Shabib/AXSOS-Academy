<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listings Search</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-md-fluid p-5 m-5 align-self-around">
    <div class="row ">
        <div class="col-3 align-self-around">
        	<a href="/guest/signin">Signing/SignUp</a>
        </div>
    </div>
    <div class="row " >
        <div class="col-6 align-self-around">
			<h2>Find a place to swim and sleep on water bnb</h2>
			<form action="/search" >	
			<p><input type="text" class="form-control" name = "location" id="floatingInput" placeholder="Location"/>
			 <button type="submit" class="btn btn-outline-warning align-self-center">Search</button></p>
			</form>
        </div>
    </div>
</div>
</body>
</html>