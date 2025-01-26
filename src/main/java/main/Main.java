package main;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("test1", "Deni",true, 2024);
		Book book1 = new Book("test2", "Deni",true, 2024);
		Book book2 = new Book("test3", "Deni",true, 2024);
	  Library library = new Library();
	  
	  
	  library.addBook(book);
	  library.addBook(book1);
	  library.addBook(book2);
	  
	  library.showAllBooks();
	  library.removeAllBooks();
	  library.showAllBooks();
	  
	}

}
