package example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet(name = "myGreetingServlet", description = "Demonstrating a simple servlet", urlPatterns = { "/greet" })
public class Greeting extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/

@Override
public void init(){
// TODO Auto-generated method stub
System.out.println("Inside init()"); //when server start this method call and msg prints on console
}

@Override
public void destroy(){
// TODO Auto-generated method stub
System.out.println("Inside destroy()"); //when server stop  this method call and msg prints on console
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//THis method is gets invoked when servlet is requested

//This method is sending HTML response back to client(in our case browser)

//Setting the MIME type for HTML response

//MIME => Multipurpose Internet Mail Extention

response.setContentType("text/html");

//Obtaining Writer object to send response

PrintWriter out = response.getWriter();

//Setting response Text

String responseText="<h1 style='color:red'>Welcome to Servlet</h1>";

//sending the response
out.println(responseText);

System.out.println("Inside doget()"); //print on console after call this method
}



}