package main;

import java.util.UUID;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Library {
		
	
		BookDAO dao = new BookDAO();
		UserDAO userDAO = new UserDAO();
		
		
		
		
		
	
		public void registerUsers(User user) {
			
			System.out.println("User Is Being Added...");
			userDAO.addUser(user);
			
		}
		
		
		public void unRegisterUsers(UUID id) {
			System.out.println("User Is Being Removed...");
			userDAO.removeUser(id);			
		}
		
		
		
		
		public void searchByISBN (int ISBN) {
			
			
			System.out.println("Searching With ISBN..." + ISBN);
			BookDAO.searchByField("ISBN",String.valueOf(ISBN), "int");
			
			}
		 
		public void searchByTitle (String name) {
			System.out.println("Searching With Title...");
			BookDAO.searchByField("name", name, "string");
			
			
		}
		
		
		public void searchByAuthor(String author) {
			
			
				System.out.println("Seaching With Author...");
				BookDAO.searchByField("authorname", author, "string");
		}
		
		//add book
		
		
		
		public void addBook(Book book) {
			
			
			
			System.out.println("Adding Book: " + book.getName() + "...");
			
			BookDAO.addBook(book);
			
			
		}
		
		public void showAllBooks() {
		  
			System.out.println("Showing All Books...");
			BookDAO.showAllBooks();
			
			
		}
		//remove book
		
		
		public void removeBook(UUID id) {
			System.out.println("Removing" + id + "...");
			BookDAO.removeBook(id);
		}
 		
		
		public void removeAllBooks() {
			System.out.println("Removing All Books...");
			BookDAO.removeAllBooks();
			
			
		}
		
		
		
}
