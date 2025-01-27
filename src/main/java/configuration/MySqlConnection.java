package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection conn() {
		String user = "deni";
		String password = "123deni123deni";
		String db = "jdbc:mysql://localhost:3306/libraryDB";

		try {
			Connection connection = DriverManager.getConnection(db, user, password);

			// System.out.println("Connection succesfull!");

			return connection;
		} catch (SQLException e) {
			// TODO: handle exception

			System.out.println("connection failed");
			e.printStackTrace();
		}
		return null;
	}

}
