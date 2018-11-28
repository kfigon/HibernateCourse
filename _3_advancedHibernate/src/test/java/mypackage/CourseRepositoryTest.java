package mypackage;

import mypackage.models.Course;
import mypackage.services.CourseRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
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
        courseRepository.updateManagedEntity();
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

    @Test
    public void query() {
        List<Course> courses = courseRepository.query();
        assertEquals(1, courses.size());
        assertEquals("praktyka programowania", courses.get(0).getName());
    }

    @Test
    public void namedQuery() {
        List<Course> courses = courseRepository.namedQuery();
        assertThat(courses.size(), Matchers.greaterThanOrEqualTo(3));
    }
}
