<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/CSS/time.css">
<script type="text/javascript" src="js/time.js"></script>
</head>
<body>
	 <%java.text.DateFormat df = new java.text.SimpleDateFormat("k:m  a"); %>
	 <h1>Current Time: <%= df.format(new java.util.Date()) %> </h1>
</body>
</html>