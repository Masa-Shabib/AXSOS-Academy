<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date </title>
<link rel="stylesheet" type="text/css" href="/CSS/date.css">
	<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
	 <%java.text.DateFormat df = new java.text.SimpleDateFormat("E,d  MMMM,YYYY"); %>
	 <h1>Current Date: <%= df.format(new java.util.Date()) %> </h1>
</body>
</html>