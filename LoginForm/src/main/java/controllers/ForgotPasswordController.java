package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

import dao.UserDao;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ForgotPasswordController() {
        super();
    }
	
	private User user = new User();
    private UserDao userDao = new UserDao();
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 String username = request.getParameter("username");
		 
		 user = userDao.findByUserName(username);
			
		 String alertMsg="";
		 String password="";
		 try
		 {
			 if(username.isEmpty() || email.isEmpty())
			 {
				 alertMsg = "Empty username or password";
				 request.setAttribute("alert", alertMsg);
				 request.getRequestDispatcher("/views/ForgotPassword.jsp").forward(request, response);
			 }
		
			 if(user!=null && email.equals(user.getEmail()))
			 {
				 password = user.getPassword();
				 request.setAttribute("success", "Password is " + password);
				 request.getRequestDispatcher("/views/ForgotPassword.jsp").forward(request, response);
			 }else
			 {
				 alertMsg = "Username or email is incorrect";
				 request.setAttribute("alert", alertMsg);
				 request.getRequestDispatcher("/views/ForgotPassword.jsp").forward(request, response);
			 }
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
	}

}
