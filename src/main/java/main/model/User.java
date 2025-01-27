package main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    private String memberID;
    private String name;
    private String phoneNumber;
    private String address;
    @OneToMany(mappedBy = "borrowedBy")
    private List<Book> borrowedBooks;

}
