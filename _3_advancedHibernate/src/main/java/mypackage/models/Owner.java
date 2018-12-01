package mypackage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    // kierunek relacji - oznaczyc kto jest wlasiccielem relacji.
    // bez tego beda 2 klucze obce!! Wlasciciela oznacza sie w tej drugiej sotrnie
    @OneToOne(fetch = FetchType.LAZY)
    private Dog dog;

    private String name;
}
