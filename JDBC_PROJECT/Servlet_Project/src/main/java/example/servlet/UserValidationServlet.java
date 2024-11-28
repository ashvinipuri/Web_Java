package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.User;
import example.bean.UserValidation;

/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/doValidate")

public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		// capturing values of 2 request parameter : uid and pwd
		String userId=request.getParameter("uid");
		String password=request.getParameter("pwd");
		
		// Creating a User object based upon userId and password
		User currentUser =new User(userId,password);
		// passing the  user object to user validation 's is valid() method for checking the validity
		boolean valid =UserValidation.isValid(currentUser);
		
		String successResponse="<h1 style='color:green'>✅Congratulations !! , you are IN🎉🎊✨</h1>";
		
		String failureResponse="<h1 style='color:red'>❌Sorry,access denied deu to invalid credentials😿🙆‍♀️🙇‍♂️🤦‍♀️</h1>";
		
		if(valid)
			out.println(successResponse);
	else
	out.println(failureResponse);
  
//		if(userId.equals("admin")&& password.equals("phoniex123"))
//			out.println(successResponse);
//		else
//			out.println(failureResponse);
//		
		// we do not run directly on server  first we run on HTML server
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
