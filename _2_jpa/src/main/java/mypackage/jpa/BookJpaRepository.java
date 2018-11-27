package mypackage.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional // trzeba zarzadzac transakcja
public class BookJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BookJpa> getAll() {
        return new ArrayList<>();
    }

    public BookJpa findById(Integer id) {
        return entityManager.find(BookJpa.class, id);
    }
}
