package main.service;

import java.util.List;
import java.util.UUID;
import main.model.Book;
import main.service.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        try {
            bookRepository.save(book);
            System.out.println("Book added: " + book.getName());
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removeBook(UUID bookId) {
        bookRepository.deleteById(bookId);
        System.out.println("Book was removed successfully");
    }

    public List<Book> searchByIsbn(int isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> searchByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> searchByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    public void showAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            System.out.println("No Books To Show");
        } else {
            books.forEach(book -> System.out.println(book.toString()));
        }
    }

    public void removeAllBooks() {
        bookRepository.deleteAll();
        System.out.println("All books have been removed");
    }
}
