package mypackage.services;

import mypackage.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class DogRepository {

    @Autowired
    private EntityManager entityManager;

    public Dog findById(Long id){
        return entityManager.find(Dog.class, id);
    }

    public Dog findByOwnerName(String name) {
        return entityManager.createQuery(
                "select d from Dog d " +
                        "left join fetch d.owner o " +
                        "where o.name = :name", Dog.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
