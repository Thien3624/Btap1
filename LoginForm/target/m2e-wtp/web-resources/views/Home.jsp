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

 <div class="mb-3">
    <h1 styles="color:red" align="center">Welcome to my home </h1>
 </div>
 <%
 	String username = (String)request.getAttribute("username");
 	String fullname = (String)request.getAttribute("fullname");
 	String email = (String)request.getAttribute("email");
 	String phone = (String)request.getAttribute("phone");
 	String image = (String)request.getAttribute("image");
 %>
    <div class="profile-image">
        <img src="<%=request.getContextPath()+"/images/"+image%> " alt="User Image">
    </div 
    
    <div class="profile-info">
        <p><strong>Username:</strong> <%= username %></p>
        <p><strong>Full Name:</strong> <%= fullname %></p>
        <p><strong>Email:</strong> <%= email %></p>
        <p><strong>Phone:</strong> <%= phone %></p>
    </div>

 <div class="mb-3">
    <a href="<%= request.getContextPath() %>/logout" class="logout-button">Log Out</a>
    
 </div>
 <div class="mb-3">
    <a href="${pageContext.request.contextPath}/change" class="btn btn-secondary">Change Information</a>
 </div>
</div>

</body>
</html>