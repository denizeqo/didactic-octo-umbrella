package main.java.services.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.configuration.MySqlConnection;
import main.java.model.User;

public class UserDAO {

	public static void removeUser(String memberID) {
		String query = "DELETE FROM Users WHERE memberID = ?";

		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, memberID);
			int rowseffected = stmt.executeUpdate();
			if (rowseffected == 1) {
				System.out.println("User Removed Succesfully");
			} else {

				System.out.println("No Users Removed");

			}

		} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("error removing user");
		}
	}

	public static void addUser(User user) {
		String addUser = "INSERT INTO Users (name,memberID,phoneNumber,address) VALUES (?,?,?,?)";
		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(addUser);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMemberID());
			stmt.setString(3, user.getPhoneNumber());
			stmt.setString(4, user.getAddress());
			stmt.executeUpdate();

			System.out.println("User Added Succesfully" + user);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Adding User to DB" + user + e.getMessage());
		}
	}
	
	
	public static void showAllUsers() {
		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Users");
			ResultSet rs = stmt.executeQuery();
			boolean foundNames;
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println("Name of the user: " + name + " MemberID: " + rs.getString("memberID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error printing out all users");
		}
	}

}
