package mypackage;

import mypackage.models.Course;
import mypackage.services.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
public class ApplicationTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findById() {
        Long id = 1L;

        Course course = courseRepository.findById(id);
        assertNotNull(course);
        assertEquals(id, course.getId());
        assertEquals("praktyka programowania", course.getName());
    }
}
