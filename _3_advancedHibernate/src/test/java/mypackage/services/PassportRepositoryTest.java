package mypackage.services;

import mypackage.models.Passport;
import mypackage.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassportRepositoryTest {

    @Autowired
    private PassportRepository passportRepository;

    // passport jest ownerem
    @Test
    public void readPassportWithStudent() {
//        jest eager
        Passport passport = passportRepository.findById(1L);
        assertNotNull(passport.getPassportDate());
        assertEquals("Adam", passport.getStudent().getName());
    }

    @Test
    public void createNew() {
        Passport passport = new Passport();
        passport.setPassportDate(new Date());
        Student student = new Student();
        student.setName("Waclaw");
        passport.setStudent(student);

        Long newId = passportRepository.create(passport).getId();

        Passport newPassport = passportRepository.findById(newId);
        assertNotNull(newPassport.getPassportDate());
        assertEquals("Waclaw", newPassport.getStudent().getName());
    }
}