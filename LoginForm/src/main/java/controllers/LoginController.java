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

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }
    private User user = new User();
    private UserDao userDao = new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user = userDao.findByUserName(username);
		
		String alertMsg="";
		try
		{
			if(username.isEmpty() || password.isEmpty())
			{
				alertMsg = "Empty username or password";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
			}

			if(user!=null && password.equals(user.getPassword()))
			{
				request.setAttribute("fullname",user.getFullname());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home.jsp");
				dispatcher.forward(request, response);
			}else
			{
				alertMsg = "Username or password is incorrect";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
