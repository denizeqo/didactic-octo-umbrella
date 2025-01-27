package main.service.repository;

import java.util.List;
import java.util.UUID;
import main.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findByIsbn(int isbn);

    List<Book> findByName(String name);

    List<Book> findByAuthorName(String authorName);
}
