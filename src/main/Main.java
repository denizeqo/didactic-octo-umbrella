package main;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  	ArrayList<Book> books = new ArrayList<>();
		  	
		  	Book GatsbyBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 9773565, true, 1925);
		  	books.add(GatsbyBook);
	        books.add(new Book("1984", "George Orwell", 9784935, true, 1949));
	        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 97120084, false, 1960));
	        
	        
	        
	        
	        
	        ArrayList<User> users = new ArrayList<>();
	        User john=  new User("John Doe", UUID.randomUUID(), 1234567890, "123 Main Street", new ArrayList<>());
	        
	        users.add(john);
	        
	        john.borrowBook(GatsbyBook);
	        
	        
	        users.add(new User("Jane Smith", UUID.randomUUID(), 987654321, "456 Elm Street", new ArrayList<>()));
	        
	        
	        ArrayList<Librarian> librarian = new ArrayList<>();
	        librarian.add(new Librarian(UUID.randomUUID().toString(), "Sarah Johnson"));
	        librarian.add(new Librarian(UUID.randomUUID().toString(), "Michael Brown"));
	        
	        
	        
	        Library library = new Library(books, users, librarian);
	        
	       library.showAllBooks();
	       
	       john.returnBook(GatsbyBook);
	       
	        
	        

	        
	        

	}

}
