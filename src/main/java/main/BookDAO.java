package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public static void searchByField(String column, String value, String dataType) {
	    String query = "SELECT " + column +" FROM Books WHERE " + value + " = ?";
	    
	    
	    try(Connection connection = MySqlConnection.conn()) {
	    	
	    	
	    	PreparedStatement stmt = MySqlConnection.conn().prepareStatement(query);
	    	
	    	switch(dataType.toLowerCase()) {
	    	case "int": 
	    		stmt.setInt(1, Integer.parseInt(value));
	    		break;
	    	case "string":
	    		stmt.setString(1, value);
	    		break;
	    	case "boolean":
	    		stmt.setBoolean(1, Boolean.parseBoolean(value));
	    		break;
	    	default: System.out.println("Unsuported DataType");
	    	return;
	    	}
	    	ResultSet rs = stmt.executeQuery();
	    	
	    	System.out.println("Book Was Found By " + column);
	    	
	    } catch (SQLException e) {
	    	System.out.println("Error Searching By " + column);
	    }
	}
}



