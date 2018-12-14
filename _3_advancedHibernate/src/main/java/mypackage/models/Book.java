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
//    mozna tak, ale tak tez dziala
//    @JoinTable(name = "book_book_authors",
//        joinColumns = @JoinColumn(name = "BOOKS_ID"),
//        inverseJoinColumns = @JoinColumn(name = "BOOK_AUTHORS_ID"))
    private List<BookAuthor> bookAuthors;
}
