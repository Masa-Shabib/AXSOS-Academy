<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
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
    			<h2>Add a Ninja</h2>
    			<a href="/dojos">Go Back</a>
                <form:form action="/ninjas/new/add" method="post" modelAttribute="ninja">
                	<div class="form-floating my-3">
                      <form:label path="dojo" for="floatingInput">Dojo</form:label>
                      <form:select path="dojo" class="form-control" >
                     <c:forEach var="dojo1" items="${dojos}">
				    <form:option value="${dojo1.id}" >
                      <c:out value="${dojo1.name}"></c:out> Location
                      </form:option>
				    </c:forEach>
				    </form:select>
                    </div>
                    <div class="form-floating my-3">
                      <form:input path="firstName" class="form-control" name = "firstName" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="firstName" for="floatingInput">FirstName</form:label>
                        <form:errors path="firstName" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input path="lastName" class="form-control" name = "lastName" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="lastName" for="floatingInput">LastName</form:label>
                        <form:errors path="lastName" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="age" type="number" min="13" class="form-control" name = "age" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="age" for="floatingInput">Age</form:label>
                    <form:errors path="age" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>