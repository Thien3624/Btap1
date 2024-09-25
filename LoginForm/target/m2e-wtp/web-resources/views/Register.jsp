<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang Ki</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/style.css">
</head>
<body>
 

 <div class="container">
  <h1>User Register Form</h1>
 <c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
 </c:if>
 <div>
  <form action ="${pageContext.request.contextPath}/register" method = "post" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="image" class="form-label">Image</label>
    <input type="file" class="form-control" name="image">
  </div>
  <div class="mb-3">
    <label for="username" class="form-label">Username</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control"  name = "email">
  </div>
  <div class="mb-3">
    <label for="phone" class="form-label">Phone</label>
    <input type="text" class="form-control"  name="phone">
  </div>
  <div class="mb-3">
    <label for="fullname" class="form-label">Fullname</label>
    <input type="text" class="form-control" name="fullname">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" name="password">
  </div>
  <button type="submit" class="btn">Register</button>
</form>
<div class="mb-3">
    <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Login</a>
 </div>
 </div> 
 
 

</body>
</html>