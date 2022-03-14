<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Here's Your Omikuji!</h1>
	<p class="omikuji">In <c:out value="${counter}"/> years, you will live in
		<c:out value="${city}"/> with <c:out value="${name}"/> as your roommate, selling 
		<c:out value="${hobby}"/> for a living. the next time you see a 
		<c:out value="${thing}"/>, you will have good luck. Also <c:out value="${desc}"/></p>
		<a href="/omikuji">Go Back</a>
</body>
</html>