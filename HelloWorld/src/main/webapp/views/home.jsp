<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Họ và tên</title>
</head>
<body>
	<h2>HTML Forms</h2>

	<form action="http://localhost:8080/HelloWorld/trang-chu" method="post">
	  <label for="fname">First name:</label><br>
	  <input type="text" id="fname" name="fname" value="John"><br>
	  <label for="lname">Last name:</label><br>
	  <input type="text" id="lname" name="lname" value="Doe"><br><br>
	  <input type="submit" value="Submit">
	</form> 
	<h1>Hello : ${holot} ${ten}</h1>
</body>
</html>