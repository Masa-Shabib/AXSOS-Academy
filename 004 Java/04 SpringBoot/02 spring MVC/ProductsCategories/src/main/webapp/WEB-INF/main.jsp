<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Categories</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<h1>All Categories</h1>
	<div class="row g-0">
	            <div class="col">
				 <a href="categories/new">Add New Category</a>
	            </div>
	            <div class="col">
				 <a href="products/new">Add New Product</a>
	            </div>
				</div>
  <div class="row g-2">
	  <c:forEach var="category" items="${categories}">
	    <div class="col-6">
	      <div class="p-3 border bg-light"><a href="/categories/${category.id}"><c:out value="${category.name}"></c:out></a></div>
	    </div>
	  </c:forEach>
  </div>
</div>
    		
</body>
</html>