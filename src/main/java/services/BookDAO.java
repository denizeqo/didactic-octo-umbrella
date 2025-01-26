package main.java.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.PrintException;

import main.java.configuration.MySqlConnection;
import main.java.model.Book;

public class BookDAO {

	public static void addBook(Book book) {
		String query = "INSERT INTO Books (name, authorName, ISBN, isAvailable, yearPublished) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = MySqlConnection.conn()) {

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthorName());
			stmt.setInt(3, book.getISBN());
			stmt.setBoolean(4, book.getAvailability());
			stmt.setInt(5, book.getYearPublished());
			stmt.executeUpdate();
			System.out.println("Book added");

		} catch (SQLException e) {

			System.out.println("Book error to add" + e.getMessage());
			e.printStackTrace();

		}

	}

	public static void removeBook(int isbn) {

		String removeBook = "DELETE FROM Books WHERE ISBN = ?";
		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(removeBook);
			stmt.setInt(1, isbn);

			int rowsEffected = stmt.executeUpdate();

			if (rowsEffected > 0) {
				System.out.println("Book was removed succesfully");

			} else {
				System.out.println("No book found with that isbn");
			}

		} catch (SQLException e) {

			System.out.println("Error removing the book" + e.getMessage());
			e.printStackTrace();

		}
	}

	public static void searchByField(String column, String value, String dataType) {
		String query = "SELECT " + column + " FROM Books WHERE " + value + " = ?";

		try (Connection connection = MySqlConnection.conn()) {

			PreparedStatement stmt = MySqlConnection.conn().prepareStatement(query);

			switch (dataType.toLowerCase()) {
			case "int":
				stmt.setInt(1, Integer.parseInt(value));
				break;
			case "string":
				stmt.setString(1, value);
				break;
			case "boolean":
				stmt.setBoolean(1, Boolean.parseBoolean(value));
				break;
			default:
				System.out.println("Unsuported DataType");
				return;
			}
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("Book Was Found By");
			} else {
				System.out.println("No Book Was Found By" + column + rs.getString(column));
			}

		} catch (SQLException e) {
			System.out.println("Error Searching By " + column);
			e.printStackTrace();
		}
	}

	public static void showAllBooks() {
		String query = "SELECT * FROM Books";
		try (Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			int i = 1;

			boolean hasBooks = false;

			while (rs.next()) {
				hasBooks = true;

				// book number
				String name = rs.getString("name");
				String authorname = rs.getString("authorname");
				int isbn = rs.getInt("ISBN");
				boolean av = rs.getBoolean("isAvailable");
				String year = rs.getString("yearPublished");

				System.out.println("Book nr-" + i + "Book Title: " + name + " Author: " + authorname + " ISBN: " + isbn
						+ " isAvailable: " + av + " Year Published: " + year);
				i++;

			}

			if (!hasBooks) {
				System.out.println("No Books To Show");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Showing All Books");
		}
	}

	public static void removeAllBooks() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you Sure You Want To Delete Every Book?");
		String query = "DELETE FROM Books";
		String answer = scanner.nextLine();

		if (answer.equals("y")) {
			try (Connection connection = MySqlConnection.conn()) {
				PreparedStatement stmt = connection.prepareStatement(query);
				stmt.execute();
				System.out.println("All books have been removed");

			} catch (SQLException e) {
				e.getMessage();
				System.out.println("error deleting all books");
			}

		} else {
			System.out.println("Removing All Books Has Stopped");
		}

	}

}
