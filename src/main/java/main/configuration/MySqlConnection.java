package main.configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySqlConnection {


	//TODO: ALWAYS use CONSTANTS For Variable Declaration globally || use application.properties (.yaml) which in your case doesnt exist.
	private static final String DB_URL = "jdbc:mysql://localhost:3306/libraryDB";
	private static final String USER = "deni";
	private static final String PASS = "123deni123deni";

	private static Connection connection;

	public static Connection conn() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				System.out.println("connection failed");
				e.printStackTrace();
			}
		}
		return connection;
	}
}
