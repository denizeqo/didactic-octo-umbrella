package main.model;

import java.util.List;
import java.util.UUID;
import main.service.BookService;
import main.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class Library {

    private final BookService bookService;
    private final UserService userService;

    public Library(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void registerUsers(User user) {
        System.out.println("User Is Being Added...");
        userService.addUser(user);
    }

    public void unRegisterUsers(String id) {
        System.out.println("User Is Being Removed...");
        userService.removeUser(id);
    }

    public void searchByISBN(int ISBN) {
        System.out.println("Searching With ISBN..." + ISBN);
        List<Book> books = bookService.searchByIsbn(ISBN);
        books.forEach(book -> System.out.println(book.toString()));
    }

    public void searchByTitle(String name) {
        System.out.println("Searching With Title...");
        List<Book> books = bookService.searchByName(name);
        books.forEach(book -> System.out.println(book.toString()));
    }

    public void searchByAuthor(String author) {
        System.out.println("Searching With Author...");
        List<Book> books = bookService.searchByAuthorName(author);
        books.forEach(book -> System.out.println(book.toString()));
    }

    public void addBook(Book book) {
        System.out.println("Adding Book: " + book.getName() + "...");
        bookService.addBook(book);
    }

    public void showAllBooks() {
        System.out.println("Showing All Books...");
        bookService.showAllBooks();
    }

    public void removeBook(UUID id) {
        System.out.println("Removing" + id + "...");
        bookService.removeBook(id);
    }

    public void removeAllBooks() {
        System.out.println("Removing All Books...");
        bookService.removeAllBooks();
    }
}
