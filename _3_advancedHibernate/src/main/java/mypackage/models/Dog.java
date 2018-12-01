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
public class Dog {
    @Id
    @GeneratedValue
    private Long id;

//    mapped by - nazwa pola z klasy nadrzednej
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "dog")
    private Owner owner;

    private String name;
}
