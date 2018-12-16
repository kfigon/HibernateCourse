package mypackage.services;

import mypackage.models.Dog;
import mypackage.models.Owner;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataOwnerRepositoryTest {
    @Autowired
    private SpringDataOwnerRepository repository;

    @Test(expected = LazyInitializationException.class)
    public void findWithoutDogThenException() {
        Optional<Owner> owner = repository.findById(1L);
        assertNull(owner.get().getDog());
    }

    @Test
    public void findWithDog_customQuery() {
        Optional<Owner> owner = repository.getOwnerWithDog(1L);
        Dog dog = owner.get().getDog();
        assertNotNull(dog);
    }

}