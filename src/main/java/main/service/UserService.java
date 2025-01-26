package main.service;

import main.configuration.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import main.model.User;

//TODO: FORMAT CODE, See other classes for reference
public class UserService {

	public static void removeUser(UUID memberID) {
		String query = "DELETE FROM Users WHERE memberID = ?";


		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setObject(1, memberID);
			int rowseffected = stmt.executeUpdate();
			if(rowseffected == 1) {
				System.out.println("User Removed Succesfully");
			} else {

				System.out.println("No Users Removed");

			}



		} catch (SQLException e) {



		}
	}



	public static void addUser(User user) {
		String addUser = "INSERT INTO Users (name,memberID,phoneNumber,address) VALUES (?,?,?,?)" ;
		try(Connection connection = MySqlConnection.conn()) {
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
