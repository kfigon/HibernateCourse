package mypackage.services;

import mypackage.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }
}
