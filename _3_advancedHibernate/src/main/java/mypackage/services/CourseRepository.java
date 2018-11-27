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

    public Course create(Course course) {
        entityManager.persist(course);
        return course;
    }

    public void delete(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }
}
