<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang Nhap</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/style.css">
</head>
<body>
<div class="container">
<c:if test="${not empty alert}">
        <p class="error-message">${alert}</p>
 </c:if>
 <div>
  <h1>User Login Form</h1>
  <form action ="${pageContext.request.contextPath}/login" method = "post">
  <div class="mb-3">
    <label for="username" class="form-label">Username</label>
    <input type="text" class="form-control" name="username">
  </div>
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" name="password">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Remember me</label>
  </div>
  <button type="submit" class="btn">Login</button>
</form>

<div class="mb-3">
      <a href="${pageContext.request.contextPath}/views/ForgotPassword.jsp" class="forget-password">Forgot Password?</a>
</div>
<div class="mb-3">
    <a href="${pageContext.request.contextPath}/register" class="btn btn-secondary">Register</a>
 </div> 
 
</body>
</html>