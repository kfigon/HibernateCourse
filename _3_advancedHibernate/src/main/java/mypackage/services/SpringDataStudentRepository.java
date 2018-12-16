package mypackage.services;

import mypackage.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface SpringDataStudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findByName(String name);
}
