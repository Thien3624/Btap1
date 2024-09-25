package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import models.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import dao.UserDao;

@MultipartConfig
@WebServlet(urlPatterns = {"/change"})
public class ChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private User user = new User();
    private UserDao userDao = new UserDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
    	Object object =  httpSession.getAttribute("username");
    	String username = "";
    	if(object != null )
		{
			username = (String) object;
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		if(username.equals("") )
		{
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		user = userDao.findByUserName(username);
    	request.setAttribute("username", user.getUsername());
    	request.setAttribute("fullname", user.getFullname());
    	request.setAttribute("email", user.getEmail());
    	request.setAttribute("phone", user.getPhone());
    	request.setAttribute("image", user.getImages());
    	request.setAttribute("password", user.getPassword());
		request.getRequestDispatcher("/views/Change.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
	    
		String phone = request.getParameter("phone");
		String fullname= request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();

		String uploadPath ="D:/eclipse_workspace/LoginForm/target/m2e-wtp/web-resources/images/" + imageFileName;
	    try (FileOutputStream fileOutputStream = new FileOutputStream(uploadPath);
	         InputStream is = file.getInputStream()) {
	         
	        byte[] buffer = new byte[1024]; // Tạo buffer để đọc dữ liệu từng phần
	        int bytesRead;
	        while ((bytesRead = is.read(buffer)) != -1) {
	            fileOutputStream.write(buffer, 0, bytesRead); // Ghi dữ liệu theo từng phần đọc
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Log lỗi cho việc xử lý file
	    }
		
    	Object object =  httpSession.getAttribute("username");
    	String username = "";
    	if(object != null )
		{
			username = (String) object;
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		if(username.equals("") )
		{
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		System.out.println(username);
		try {
			if( password.isEmpty() || fullname.isEmpty())
			{
				
				String errorMessage = "Empty information";
				request.setAttribute("errorMessage", errorMessage);
				user = userDao.findByUserName(username);
				request.setAttribute("username", user.getUsername());
		    	request.setAttribute("fullname", user.getFullname());
		    	request.setAttribute("email", user.getEmail());
		    	request.setAttribute("phone", user.getPhone());
		    	request.setAttribute("image", user.getImages());
				request.getRequestDispatcher("/views/Change.jsp").forward(request, response);
				return;
			}
			else
			{
				
				user = userDao.findByUserName(username);
				user.setImages(imageFileName);
				user.setFullname(fullname);
				user.setPhone(phone);
				user.setPassword(password);
				userDao.changeInformation(user);
				
				request.setAttribute("username", user.getUsername());
		    	request.setAttribute("fullname", user.getFullname());
		    	request.setAttribute("email", user.getEmail());
		    	request.setAttribute("phone", user.getPhone());
		    	request.setAttribute("image", user.getImages());

				request.getRequestDispatcher("/views/Change.jsp").forward(request, response);
				return;
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
