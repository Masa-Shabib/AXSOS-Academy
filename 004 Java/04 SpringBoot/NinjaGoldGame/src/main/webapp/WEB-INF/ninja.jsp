<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<header>
        <div>
            <h4>Your Gold: </h4>
            <p><c:out value="${gold}"/></p>
        </div>
        <form action="destroy_session">
            <input type="submit" value='Reset'> 
        </form>
    </header>
    <main>
        <div>
            <h3>Farm</h3>
            <p>(earns 10-20 golds)</p>
            <form action="process_money" method="post">
                <input type="hidden" name="which_form" value="farm">
                <input type="submit" value='Find Gold!' class="sub"> 
            </form>
        </div>
        <div>
            <h3>Cave</h3>
            <p>(earns 5-10 golds)</p>
            <form action="process_money" method="post">
                <input type="hidden" name="which_form" value="cave">
                <input type="submit" value='Find Gold!'class="sub" > 
            </form>
        </div>
        <div>
            <h3>House</h3>
            <p>(earns 2-5 golds)</p>
            <form action="process_money" method="post">
                <input type="hidden" name="which_form" value="house">
                <input type="submit" value='Find Gold!' class="sub"> 
            </form>
        </div>
        <div>
            <h3>Casino</h3>
            <p>(earns/takes 0-50 golds)</p>
            <form action="process_money" method="post">
                <input type="hidden" name="which_form" value="casino">
                <input type="submit" value='Find Gold!' class="sub"> 
            </form>
        </div>
        <div>
            <h3>Spa</h3>
            <p>(takes 5-20 golds)</p>
            <form action="process_money" method="post">
                <input type="hidden" name="which_form" value="spa">
                <input type="submit" value='Find Gold!' class="sub"> 
            </form>
        </div>
    </main>
        <h5>Activities:</h5>
    <footer>
        <c:out value="${result}" escapeXml="false"/>
    </footer>
</body>
</html>