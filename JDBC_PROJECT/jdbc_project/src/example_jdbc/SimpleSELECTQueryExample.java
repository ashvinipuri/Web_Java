package example_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {
// this program tries a simple SELECT query and shows the data loaded 
	public static void main(String[] args)  {
		
	
	// 1 step: load the driver
		String driverClassName ="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/zomato";
		String uid ="root";
		String pwd ="password";
		
		Connection dbConnection =null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			Class.forName(driverClassName);
			System.out.println("Driver loaded");
			
			// 2 step: Establish Connection with DB
		 dbConnection =DriverManager.getConnection(url, uid, pwd);
			System.out.println("Connected to DB");
			
			//3 step: Obtain some statement
			 stmt =dbConnection.createStatement();
			System.out.println("Obtained the Statement");
			
			// 4 step: Execute SQL Query
			String sqlQuery = "select rest_name,rest_branch_count,rest_cuisine from restaurant_master";
		rs =stmt.executeQuery(sqlQuery);
			System.out.println("Executed SQL SELECT query and Obtained ResultSet");
			
			
			// 5 step: In case of SELECT Query,obtain ResultSet and perform navigation
			  while(rs.next()) {
				  String restaurantName =rs.getString(1);
				  int branchCount =rs.getInt(2);
				  String restaurantCuisine =rs.getString(3);
				  System.out.println();
				  System.out.println(restaurantName + " \t " + branchCount + " \t " +restaurantCuisine );
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to Proceed");
		}
		finally {
			// closing all the resources : ResultSet,Statement,Connection
			try {
				rs.close();
				stmt.close();
				dbConnection.close();	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
