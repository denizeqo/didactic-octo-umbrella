package services;

import model.Book;
import model.User;
import services.DAO.BookDAO;
import services.DAO.UserDAO;

import java.util.UUID;


public class LibrarianServices {

	BookDAO dao = new BookDAO();
	UserDAO userDAO = new UserDAO();
	
	public void registerUsers(User user) {

		System.out.println("User Is Being Added...");
		userDAO.addUser(user);

	}

	public void unRegisterUsers(User user) {
		System.out.println("User Is Being Removed...");
		userDAO.removeUser(user.getMemberID());
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

	public void addBook(Book book) {

		System.out.println("Adding Book: " + book.getName() + "...");

		BookDAO.addBook(book);

	}

	public void showAllBooks() {

		System.out.println("Showing All Books...");
		BookDAO.showAllBooks();

	}				

	public void removeBook(int isbn) {
		System.out.println("Removing" + isbn + "...");
		BookDAO.removeBook(isbn);
	}

	public void removeAllBooks() {
		System.out.println("Removing All Books...");
		BookDAO.removeAllBooks();

	}


	
	
	public static void approveBook(int ISBN, UUID userid) {
		
	}


}
