package mypackage.services;

import mypackage.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }
}
