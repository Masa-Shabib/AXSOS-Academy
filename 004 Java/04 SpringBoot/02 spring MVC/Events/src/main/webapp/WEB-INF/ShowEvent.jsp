<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Details</title>
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
                <h2><c:out value="${event.name}"></c:out></h2>
            </div>
            <div class = "col-2 ">
                <a href="/events">Go Back</a>
            </div>
        </div>
        <div class = "row justify-content-between mt-5">
         <div class = "col-5 align-self-between p-3" >
           <p>Host: <c:out value="${event.host.firstName}"></c:out> <c:out value="${event.host.lastName}"></c:out></p>
           <p>Date: <c:out value="${event.eventDate}"></c:out></p>
           <p>Location : <c:out value="${event.location}"></c:out>,  <c:out value="${event.state}"></c:out></p>
           <p>People who are attending this event : <c:out value="${atendee.size()}"></c:out></p>

				<table class="table border col-5  ">
				  <thead>
				    <tr>
				      	<th scope="col" class = "col-1 ">Name</th>
				      	<th scope="col" class = "col-1 ">Location</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="item" items="${atendee}">
				    <tr>
				    	<td><c:out value="${item.firstName}"></c:out> <c:out value="${item.lastName}"></c:out></td>
				    	<td><c:out value="${item.state}"></c:out></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>		
        </div>
    <div class = "col-5 align-self-center p-3" >
    	<h2>Message Wall</h2>
     	<div class = "overflow-auto border p-3" style="height:200px;">
           <c:forEach var="item" items="${eventmessages}">
				<p><c:out value="${item.messageUser.firstName}"></c:out> <c:out value="${item.messageUser.lastName}"></c:out>:  <c:out value="${item.text}"></c:out></p>
				<p>---------------------</p>
			</c:forEach>
        </div>
        <div class = "row justify-content-between mt-5">
           <form:form action="/events/${event.id}/add" method="post" modelAttribute="message">
                <form:input type="hidden" path="messageUser"  value="${user.id}"/>
                  <form:input type="hidden" path="messageEvent"  value="${event.id}"/>
					<div class="form-floating mb-4">
                      <form:textarea path="text" class="form-control" placeholder="Leave a comment here" name = "text" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="text" for="floatingTextarea2">Add a Comment:</form:label>
                    <form:errors path="text" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Comment</button>
                    </form:form>
        </div>
    </div>
    </div>
    </div>
</body>
</html>