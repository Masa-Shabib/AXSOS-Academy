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
            	<h1 style="color: Blue">Expense Details</h1><a href="/travels">Go Back</a>
                <h3 class = "mb-3"><strong>Expense Name:</strong> <c:out value="${travels.name}"/></h3>
                <p style = "font-size: 20px;"><strong>Expense Description:</strong> <c:out value="${travels.description}"/></p>
                <p style = "font-size: 20px;"><strong>Vendor:</strong> <c:out value="${travels.vendor}"/></p>
                <p style = "font-size: 20px;"><strong>Amount: $</strong> <c:out value="${travels.amount}"/></p>
            </div>
        </div>
    </div>	
</body>
</html>