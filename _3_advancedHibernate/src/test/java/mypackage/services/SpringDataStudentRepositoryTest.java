package mypackage.services;

import mypackage.models.Student;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataStudentRepositoryTest {

    @Autowired
    private SpringDataStudentRepository repository;

    @Test
    public void findAll() {
        Iterable<Student> allIt = repository.findAll();
        List<String> imiona = new LinkedList<>();
        allIt.forEach(student -> imiona.add(student.getName()));

        assertThat(imiona, Matchers.containsInAnyOrder("Marek", "Adam"));
    }

    @Test
    public void findOne() {
        Optional<Student> student = repository.findById(1L);
        assertTrue(student.isPresent());
        assertEquals("Adam", student.get().getName());
    }

    @Test
    public void customoweQuery() {
        Optional<Student> marek = repository.findByName("Marek");
        assertTrue(marek.isPresent());
        assertEquals(2L, marek.get().getId().intValue());
    }

}