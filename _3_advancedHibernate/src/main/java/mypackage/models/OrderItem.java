package mypackage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne
    private Order order;
}
