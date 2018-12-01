package mypackage.services;

import mypackage.models.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogRepositoryTest {

    @Autowired
    private DogRepository dogRepository;

    @Test
    public void findById() {
        Dog dog = dogRepository.findById(1L);
        assertEquals("Fafik", dog.getName());
        assertEquals("Jan", dog.getOwner().getName());
        // nawet lazy zaciaga jak jest po stronie zaleznej
    }

    @Test
    public void findByOwnerName() {
        Dog dog = dogRepository.findByOwnerName("Jan");
        assertEquals("Fafik", dog.getName());
        assertEquals("Jan", dog.getOwner().getName());
    }
}