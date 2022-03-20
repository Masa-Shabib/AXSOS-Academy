<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
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
            	<a href="/">Go Back</a>
				<h1><c:out value="${category.name}"></c:out></h1>
				<ul>
				<c:forEach var="product" items="${category.products}">
					<li><a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
				    </c:forEach>
				</ul>
				<div class="form-floating my-3">
						<h3>Products:</h3>
					<form action="/categories/${category.id}/relate" >
	                      <select name="product" class="form-control" >
	                     <c:forEach var="product" items="${products}">
					    <option value="${product.id}" >
	                      <c:out value="${product.name}"></c:out> 
	                      </option>
					    </c:forEach>
					    </select>
					     <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
				    </form>
                    </div>
    </div>
    </div>

    </div>
    		
</body>
</html>