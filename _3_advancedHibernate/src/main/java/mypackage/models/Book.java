package mypackage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    // na ownerze definiuje.
    // ta adnnotacja jest nadmiarowa, jesli sami definiujemy strukture bazy
    // jesli nie przeszkadza nam books_id i book_authors_id to nic nie trzeba robic
    // dla performancu wystarcza mapped by.
    @JoinTable(name = "BOOK_BOOK_AUTHORS",
            joinColumns = @JoinColumn(name = "books_id"),
    inverseJoinColumns = @JoinColumn(name = "book_authors_id"))
    private List<BookAuthor> bookAuthors;
}
