package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns= {"/home","/trang-chu"})
public class Homecontroller extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(holot + " " + ten);
		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String ten = req.getParameter("fname");
		String holot = req.getParameter("lname");
		
		req.setAttribute("ten", ten);
		req.setAttribute("holot", holot);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/home.jsp");
		dispatcher.include(req, resp);
	}
}
