package main;

import java.util.UUID;

public class Librarian {
	
	
	
	private UUID librarianId;
	private String librarianName;
	
	public void addBookToLibrary(Library library, Book book) {
		
		library.addBook(book);
		
	}

	
	public void removeBook(Library library, Book book) {
		library.removeBook(book);
	}
	
	

}
