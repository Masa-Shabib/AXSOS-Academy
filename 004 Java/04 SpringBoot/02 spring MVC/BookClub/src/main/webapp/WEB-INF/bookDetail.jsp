<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Detail</title>
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
	<div class = "row justify-content-between ">
    		<div class = "col-5 ">
    			<h2><c:out value="${book.title}"></c:out></h2>    			
    		</div>
    		<div class = "col-2 ">
    			<a href="/books">Back to the shelves</a>
    		</div>
    	</div>
    	<div class = "row justify-content-between mt-5">
    		<div class = "col-7 ">
    			<h4><span style="color:red "><c:out value="${L1}"></c:out></span> read <span style="color:#a218ff"><c:out value="${book.title}"></c:out></span>
    			 by <span style="color:#08a117 "><c:out value="${book.author}"></c:out></span></h4>  
    			<h5>Here are <c:out value="${L2}"></c:out> thoughts</h5>   			
    		</div>
    	</div>
        <div class = "row justify-content-between mt-5">
         <div class = "col-3 align-self-center p-3" style="border-top:1px solid black;border-bottom:1px solid black ">
           <p ><c:out value="${book.thought}"></c:out></p>
    	</div>
    </div>
    <div class = "row justify-content-between mt-5">
         <div class = "col-3 align-self-center " >
			<% if(session.getAttribute("user") == session.getAttribute("edit")){ %>
			<p><a href="/books/${book.id}/edit">Edit</a></p>
			<%} %>
    	</div>
    </div>
	    

    </div>
    		
</body>
</html>