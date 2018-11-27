package mypackage.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book") // bo inna nazwa tabeli
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookJpa {

    @Id // java persistance, nie spring.data.annotation!!!!
    @GeneratedValue
    private Integer id;

//    @Column(name='asd') // jesli nazwa kolumny inna
    private String author;

    private String title;
}
