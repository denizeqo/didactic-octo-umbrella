package main;

import java.util.Scanner;
import main.model.Book;
import main.model.Library;

public class Main {


    public static void main(String[] args) {


        //TODO : Remove unused methods if not needed
        Scanner scanner = new Scanner(System.in);

        Library library = new Library();


        Book book = new Book("test", "test", false, 12321, 21312, 123);


        library.addBook(book);
        library.showAllBooks();
	}

}
