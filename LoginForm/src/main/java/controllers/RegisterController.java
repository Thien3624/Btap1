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
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalTime;

import dao.UserDao;

@MultipartConfig
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
		user.setImages(imageFileName);
		user.setPhone(phone);
		user.setCreatedDate(date);
		
		
		try {
			if(username.isEmpty() || password.isEmpty() || email.isEmpty() || fullname.isEmpty())
			{
				String errorMessage = "Empty information";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("/views/Register.jsp").forward(request, response);
				return;
			}
			
			if(userDao.checkExistEmail(email) || userDao.checkExistUsername(username))
			{
				request.setAttribute("errorMessage", "Username or Email already exists");
                request.getRequestDispatcher("/views/Register.jsp").forward(request, response);
                return;

			}
			else
			{
				userDao.registerUser(user);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", username);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
				dispatcher.forward(request, response);
				return;
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
	}

}
