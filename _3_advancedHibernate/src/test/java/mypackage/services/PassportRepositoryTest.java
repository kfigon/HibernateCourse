package mypackage.services;

import mypackage.models.Passport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassportRepositoryTest {

    @Autowired
    private PassportRepository passportRepository;

    // passport jest ownerem
    @Test
    public void readPassportWithStudent() {
        Passport passport = passportRepository.findById(1L);
        assertNotNull(passport.getPassportDate());
        assertEquals("Adam", passport.getStudent().getName());
    }
}