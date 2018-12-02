package mypackage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50)
    private String topic;

    @OneToMany
    @JoinColumn(name = "post_id") // bez tego hibernate zrobi dodatkowa tabele!
    private List<Comment> comments;
}
