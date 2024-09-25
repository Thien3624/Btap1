package controllers;

import java.io.IOException;

import com.mysql.cj.Session;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

//@MultipartConfig
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
    private User user = new User();
    private UserDao userDao = new UserDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession httpSession = req.getSession();
    	Object object =  httpSession.getAttribute("username");
    	String username = (String) object;
    	
    	user = userDao.findByUserName(username);
    	System.out.println(user.toString());
    	req.setAttribute("username", user.getUsername());
    	req.setAttribute("fullname", user.getFullname());
    	req.setAttribute("email", user.getEmail());
    	req.setAttribute("phone", user.getPhone());
    	req.setAttribute("image", user.getImages());
    	
    	req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession httpSession = req.getSession();
    	Object object =  httpSession.getAttribute("username");
    	String username = "";
    	if(object != null )
		{
			username = (String) object;
		}
		else
		{
			resp.sendRedirect(req.getContextPath()+"/login");
		}
		
		if(username.equals("") )
		{
			resp.sendRedirect(req.getContextPath()+"/login");
		}
    	
    	user = userDao.findByUserName(username);
    	System.out.println(user.toString());
    	req.setAttribute("username", user.getUsername());
    	req.setAttribute("fullname", user.getFullname());
    	req.setAttribute("email", user.getEmail());
    	req.setAttribute("phone", user.getPhone());
    	req.setAttribute("image", user.getImages());
    	
    	req.getRequestDispatcher("/views/Home.jsp").forward(req, resp);

    }
    
}
