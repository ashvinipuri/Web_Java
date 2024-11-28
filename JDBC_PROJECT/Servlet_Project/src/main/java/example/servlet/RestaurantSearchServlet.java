package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.Restaurant;
import exaples.dao.DaoInterface;
import exaples.dao.RestaurantDao;

/**
 * Servlet implementation class RestaurantSearchServlet
 */
@WebServlet("/search")
public class RestaurantSearchServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out=response.getWriter();
String id=request.getParameter("r_id");
int restaurantId=Integer.parseInt(id);

DaoInterface<Restaurant, Integer> daoref=new RestaurantDao();

Restaurant foundRestaurant =daoref.retrieveOne(restaurantId);
if(foundRestaurant==null) {
RequestDispatcher dispatcher=
request.getRequestDispatcher("search_restaurant.html");
out.println("<h2>Restaurant with given ID not found. Please try again");
dispatcher.include(request, response);
}else {
//Obtain RequestDispatcher for next servlet : /display
	RequestDispatcher dispatcher=
			request.getRequestDispatcher("display");
	// Attach the Restaurant data to the current request
	request.setAttribute("searchedRestaurant",foundRestaurant);
	// forward the request to the next servlet
	dispatcher.forward(request, response);
}
}

}