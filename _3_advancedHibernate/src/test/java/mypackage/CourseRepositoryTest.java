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
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findById() {
        Long id = 1L;

        Course course = courseRepository.findById(id);
        assertEquals(id, course.getId());
        assertEquals("praktyka programowania", course.getName());
    }

    @Test
    public void createNewCourse() {
        // given
        String newName = "some  funny name";
        Course course = Course.builder().name(newName).build();
        // when
        courseRepository.create(course);
        Course persisted = courseRepository.findById(4L);
        // then
        assertNotNull(persisted.getId());
    }
    
    @Test
    public void deleteNewCourse() {
        // given
        Long id = 2L;
        // when
        courseRepository.delete(id);

        assertNull(courseRepository.findById(id));
    }

    @Test
    public void update() {
        Long id = 3L;
        Course course = courseRepository.findById(id);
        String newName = "some very cool name";
        course.setName(newName);

        courseRepository.update(course);

        Course persisted = courseRepository.findById(id);

        assertEquals(newName, persisted.getName());
    }
    
    @Test
    public void updateManagedEntity() {
        courseRepository.asd();
    }
    
    @Test
    public void flush() {
        courseRepository.flush();
    }

    @Test
    public void detach() {
        courseRepository.detach();
    }

    @Test
    public void refresh() {
        courseRepository.refresh();
    }
}
