<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>
<div class="container">
	<c:if test="${not empty success}">
	        <p class="success-message">${success}</p>
	 </c:if>
	 <c:if test="${not empty alert}">
        <p class="error-message">${alert}</p>
 	</c:if>
    <h1>Forgot Password</h1>
    <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Enter your email address</label>
            <input type="email" class="form-control" name="email" required>
        </div>
        <div class="mb-3">
    		<label for="username" class="form-label">Username</label>
    		<input type="text" class="form-control" name="username">
  		</div>
        <button type="submit" class="btn">Submit</button>
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Return to Login</a>
</div>
</body>
</html>