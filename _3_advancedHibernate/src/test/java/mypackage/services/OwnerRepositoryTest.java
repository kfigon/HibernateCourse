package mypackage.services;

import mypackage.models.Owner;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test(expected = LazyInitializationException.class)
    public void findById() {
        Owner owner = ownerRepository.findById(1L);
        assertEquals("Jan", owner.getName());
        assertNull(owner.getDog()); // proxy wysypuje bo nie ma transakcji
    }

    @Test
    public void getWithDog() {
        Owner owner = ownerRepository.getWithDog(1L);
        assertEquals("Jan", owner.getName());
        assertEquals("Fafik", owner.getDog().getName());
    }
}