package mypackage.services;

import mypackage.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class ManyToManyRepository {
    @Autowired
    private EntityManager entityManager;

    public Book getBookById(Long id) {
        return entityManager.createQuery("Select b from Book b " +
                "left join fetch b.bookAuthors " +
                "where b.id=:id", Book.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
