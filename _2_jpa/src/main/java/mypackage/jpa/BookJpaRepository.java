package mypackage.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional // trzeba zarzadzac transakcja
public class BookJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BookJpa> getAll() {
//        HQL
        return entityManager.createQuery("from BookJpa").getResultList();
    }

    public List<BookJpa> getAllNamedQuery() {
        // adnotacja named query na encji. HQL
        return entityManager.createNamedQuery("find_all_books").getResultList();
    }

    public BookJpa update(BookJpa bookJpa) {
        return entityManager.merge(bookJpa); // update/insert - MERGE. sprawdzi czy jest id i bedzie update/create. Ale lepiej uzywac oddzielnie
    }

    public void insert(BookJpa bookJpa) {
        entityManager.persist(bookJpa);
    }

    public BookJpa findById(Integer id) {
        return entityManager.find(BookJpa.class, id);
    }
}
