package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalTime;

import dao.UserDao;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterController() {
        super();
    }
    
    private User user = new User();
    private UserDao userDao = new UserDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/Register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setPhone(phone);
		user.setCreatedDate(date);
		
		
		try {
			if(username.isEmpty() || password.isEmpty() || email.isEmpty() || fullname.isEmpty())
			{
				String errorMessage = "Empty information";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("/views/Register.jsp").forward(request, response);
			}
			
			if(userDao.checkExistEmail(email) || userDao.checkExistUsername(username))
			{
				request.setAttribute("errorMessage", "Username or Email already exists");
                request.getRequestDispatcher("/views/Register.jsp").forward(request, response);

			}
			else
			{
				userDao.registerUser(user);
				request.setAttribute("fullname",fullname);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home.jsp");
				dispatcher.forward(request, response);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
	}

}
