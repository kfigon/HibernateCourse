package mypackage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table gdy inna nazwa tabeli, pamietac o underscore w tabeli vs camelcase w javie
@NamedQuery(name="get_all", query = "select c from Course c")

//@NamedQueries(value={
//@NamedQuery(),//@NamedQuery(),
//})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 32)
    private String name;

//    @UpdateTimestamp, @CreateTimestamp - hibernate automagicznie sam uzupelni timestampy
//    private LocalDateTtime lastUpdateTime
}
