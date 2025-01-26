package main;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    
    public static void main(String[] args) {
		

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();
        
        
        Book book = new Book("test", "test", false, 12321, 21312, 123);
        
        
        library.addBook(book);
        library.showAllBooks();
	}
    
}
