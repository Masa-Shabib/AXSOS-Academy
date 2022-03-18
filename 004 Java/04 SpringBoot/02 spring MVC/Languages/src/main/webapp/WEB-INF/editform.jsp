<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class = "row justify-content-center">
            <div class = "col-5 align-self-center">
            	<h1>Edit Language</h1><a href="/languages">Go Back</a>
                <form:form action="/languages/${languages.id}/edit/update" method="post" modelAttribute="languages">
                <input type="hidden" name="_method" value="put">
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Expense Name</form:label>
                        <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="creator" type="text" class="form-control" name = "creator" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="creator" for="floatingInput">Creator</form:label>
                        <form:errors path="creator" class = "my-3"  style="color: red;"/>
                    </div>
                    <div class="form-floating mb-3">
                      <form:input path="version" type="text" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="version" for="floatingInput">Version</form:label>
                    <form:errors path="version" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
                    </form:form>
    		</div>
    		</div>
    		
</body>
</html>