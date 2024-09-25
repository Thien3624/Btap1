<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change information</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/style.css">
</head>
<body>
<div class="container">
  <h1>Change information</h1>
 <c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
 </c:if>
 
  <%
 	String username = (String)request.getAttribute("username");
 	String fullname = (String)request.getAttribute("fullname");
 	String email = (String)request.getAttribute("email");
 	String phone = (String)request.getAttribute("phone");
 	String image = (String)request.getAttribute("image");
 	String password = (String)request.getAttribute("password");
 %>
 <div>
  <form action ="${pageContext.request.contextPath}/change" method = "post" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="image" class="form-label">Image</label>
    <input type="file" class="form-control" name="image" value="<%=image%>">
  </div>
  <div class="profile-image">
        <img src="<%=request.getContextPath()+"/images/"+image%> " alt="User Image">
   </div 
  <div class="mb-3">
    <label for="phone" class="form-label">Phone</label>
    <input type="text" class="form-control"  name="phone" value="<%=phone%>" >
  </div>
  <div class="mb-3">
    <label for="fullname" class="form-label">Fullname</label>
    <input type="text" class="form-control" name="fullname" value="<%=fullname%>" >
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" name="password" value="<%=password%>">
  </div>
  <button type="submit" class="btn">Submit</button>
</form>
<div class="mb-3">
    <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Exit</a>
 </div>
 </div> 
 
</body>
</html>