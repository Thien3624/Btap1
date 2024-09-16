<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/style.css">
</head>
<body>
<div class="container">
<div>
 <div class="mb-3">
    <h1>Welcome <%= request.getAttribute("fullname") %> </h1>
 </div>
 <div class="mb-3">
    <a href="<%= request.getContextPath() %>/login" class="logout-button">Log Out</a>
 </div>
</div>
</div>
<div class="mb-3">
    <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Login</a>
 </div>
</body>
</html>