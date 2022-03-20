<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
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
	            <div class="row g-0">
	            <div class="col">
				 <a href="dojos/new">Add New Dojo</a>
	            </div>
	            <div class="col">
				 <a href="ninjas/new">Add New Ninja</a>
	            </div>
	            <div class="col">
	            	<div class="row g-0">
					 <form action="/search" >
					 	<input type="text" class="form-control" name ="txtsearch" id="floatingInput" placeholder="Search" />
					     <button type="submit" class="btn btn-info " style="margin:5px 0 0 120px">Search</button>
					 </form>
					 </div>
	            </div>
				</div>
				<h1>All Dojos</h1>
                <table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">Location</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="dojo" items="${dojos}">
				    <tr>
				        <td><c:out value="${dojo.name}"></c:out></td>
				    	<td><a href="/dojos/${dojo.id}">See Students</a></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
    </div>
    </div>

    </div>
    		
</body>
</html>