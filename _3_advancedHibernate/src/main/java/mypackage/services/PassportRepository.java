package mypackage.services;

import mypackage.models.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class PassportRepository {

    @Autowired
    private EntityManager entityManager;

    public Passport findById(long id) {
        return entityManager.find(Passport.class, id);
    }

    public Passport create(Passport passport) {
        entityManager.persist(passport.getStudent());
        entityManager.persist(passport);
// odwrotnie bedzie jeszce update musial isc!
        // save ppassport, save student, update passport
//        albo transient update exception poleci.

        // zawsze zaczynac od strony zarzadzanej (nie zarzadzajacej)
        return passport;
    }
}
