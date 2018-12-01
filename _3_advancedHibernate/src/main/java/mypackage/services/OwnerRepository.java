package mypackage.services;

import mypackage.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class OwnerRepository {

    @Autowired
    private EntityManager entityManager;

    public Owner findById(Long id) {
        return entityManager.find(Owner.class, id);
    }

    public Owner getWithDog(Long id) {
        return entityManager.createQuery(
                "select o from Owner o " +
                        "left join fetch o.dog " +
                        "where o.id=:id", Owner.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
