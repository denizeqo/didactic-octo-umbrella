package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import configuration.MySqlConnection;
import services.DAO.BookDAO;
import services.DAO.UserDAO;
import services.LibrarianServices;
import services.LibrarianServices;

public class UserServices {
	BookDAO dao = new BookDAO();
	UserDAO userDAO = new UserDAO();
	
	
	public void showAllBooks() {

		System.out.println("Showing All Books...");
		BookDAO.showAllBooks();
		

	}
	
	public void searchByISBN(int ISBN) {

		System.out.println("Searching With ISBN..." + ISBN);
		BookDAO.searchByField("ISBN", String.valueOf(ISBN), "int");

	}

	public void searchByTitle(String name) {
		System.out.println("Searching With Title...");
		BookDAO.searchByField("name", name, "string");

	}

	public void searchByAuthor(String author) {

		System.out.println("Seaching With Author...");
		BookDAO.searchByField("authorname", author, "string");
	}

	
	
	

}
