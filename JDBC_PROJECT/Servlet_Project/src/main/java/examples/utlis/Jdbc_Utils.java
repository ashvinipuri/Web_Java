package examples.utlis;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_Utils {
	public static Connection getConnection() throws Exception {

		// Here, class.forName is not used because it is not needed.

		// The driver gets loaded automatically.
Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/zomato";

		String uid = "root";

		String pwd = "password";

		Connection dbConnection = DriverManager.getConnection(url, uid, pwd);

		return dbConnection;

	}

}
