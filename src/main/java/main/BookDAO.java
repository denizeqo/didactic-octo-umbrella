package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
	
	
	public static void addBook(Book book) {
		String query = "INSERT INTO Books (name, authorName, ISBN, av, yearPublished) VALUES (?, ?, ?, ?, ?)";
		try(Connection connection = MySqlConnection.conn()) {
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthorName());
			stmt.setInt(3, book.getISBN());
			stmt.setBoolean(4, book.getAvailability());
			stmt.setInt(5, book.getYearPublished());
			stmt.executeUpdate();
			System.out.println("Book added");
			
		} catch(SQLException e) {
			
		System.out.println("Book error to add" + e.getMessage());
		
			
		}
		
		
	}
	
	public static void removeBook(Book book) {

		String removeBook = "DELETE FROM Books WHERE ISBN = ?";
		try(Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(removeBook);
			stmt.setInt(1, book.getISBN());
			
			int rowsEffected = stmt.executeUpdate();
			
			if (rowsEffected > 0) {
				System.out.println("Book was removed succesfully");
				
			} else {
				System.out.println("No book found with that isbn");
			}
			
		} catch(SQLException e) {
			
			System.out.println("Error removing the book" + e.getMessage());
			
		}
	}
	
	
	public static void searchByISBN(int ISBN) {
		
		String query = "SELECT isbn FROM books WHERE isbn= ?";
		
		try(Connection connection = MySqlConnection.conn()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setInt(1, ISBN);
			
		} catch (SQLException e){
			
		}
		
	}
}



