package mypackage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50)
    private String content;
}
