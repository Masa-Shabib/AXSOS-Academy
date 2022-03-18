<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travels</title>
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
				<h1>All Travels</h1>
                <table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">Expense</th>
				      <th scope="col">Vendor</th>
				      <th scope="col">Amount</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="travel" items="${travels}">
				    <tr>
				    	<td><a href="/travels/${travel.id}"><c:out value="${travel.name}"></c:out></a></td>
				        <td><c:out value="${travel.vendor}"></c:out></td>
				      	<td><c:out value="${travel.amount}"></c:out></td>
				      	<td><a href="/travels/${travel.id}/edit">Edit</a><form action="/travels/${travel.id}/delete" method="post">
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
    			<h2>Add an Expense</h2>
                <form:form action="/travels/create" method="post" modelAttribute="travel">
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Expense Name</form:label>
                        <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="vendor" type="text" class="form-control" name = "vendor" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="vendor" for="floatingInput">Vendor</form:label>
                        <form:errors path="vendor" class = "my-3"  style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="amount" type="number" class="form-control" name = "amount" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="amount" for="floatingInput">Amount</form:label>
                    <form:errors path="amount" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-4">
                      <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "amount" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="description" for="floatingTextarea2">Description</form:label>
                    <form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>