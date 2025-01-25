package main;

import java.util.ArrayList;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  	ArrayList<Book> books = new ArrayList<>();
	        
	        
	        ArrayList<User> users = new ArrayList<>();
	 
	        
	        
	        ArrayList<Librarian> librarian = new ArrayList<>();
	  
	        
	        Library library = new Library(books, users, librarian);
	        
	       library.showAllBooks();
	       Book newBook = new Book("TEst", "TETST", 124124, true, 2024);
	 library.addBook(newBook);
	 library.removeBook(newBook);
	 
	       MySqlConnection.conn();
	       
	        

	        
	        

	}

}
