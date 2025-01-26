package main.java.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			System.out.println("Error Adding User to DB" + user + e.getMessage());
		}
	}

}
