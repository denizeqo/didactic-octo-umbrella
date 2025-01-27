package main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    private UUID bookID;
    private String name;
    private String authorName;
    private Integer isbn;
    private Boolean availability;
    private Integer yearPublished;
    private Integer numberOfCopies;

}
