<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Send an Omikuji!</h1>
	<form action="/omikuji/send" method="post">
		<label for="num">Pick any number from 5 to 25</label>
		<input type="number" name="counter" min="5" max="25" />
		<label >Enter the name of any city:</label>
		<input type="text" name="city" />
		<label >Enter the name of any real person:</label>
		<input type="text" name="name" />
		<label >Enter the professional endeavor or hobby:</label>
		<input type="text" name="hobby" />
		<label >Enter any type of living thing:</label>
		<input type="text" name="thing" />
		<label >Say something nice to someone:</label>
		<textarea name="desc" rows="4" cols="50"></textarea>
		<p>Send and show a friend!</p>
		<input type="submit" value="send" class="sub"/>
	</form>
</body>
</html>