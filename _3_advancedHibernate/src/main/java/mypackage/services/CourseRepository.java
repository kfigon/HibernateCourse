package mypackage.services;

import mypackage.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void create(Course course) {
        entityManager.persist(course);
    }

    public void delete(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    // mamy transakcje, wiec sie zmieni - pojdize update.
    // po wyjsciu z tego jest SDADASDSA
    public void asd() {
        Course c = Course.builder().name("ASD").build();
        entityManager.persist(c);
        c.setName("SDADSASD");
    }
}
