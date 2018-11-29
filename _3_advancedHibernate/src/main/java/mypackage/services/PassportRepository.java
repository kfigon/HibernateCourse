package mypackage.services;

import mypackage.models.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PassportRepository {

    @Autowired
    private EntityManager entityManager;

    public Passport findById(long id) {
        return entityManager.find(Passport.class, id);
    }
}
