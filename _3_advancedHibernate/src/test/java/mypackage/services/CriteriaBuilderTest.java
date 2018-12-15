package mypackage.services;


import mypackage.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaBuilderTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void criteriaBuilderTest() {
        // select * from post;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = criteriaBuilder.createQuery(Post.class);

        Root<Post> from = query.from(Post.class);

        // tu po drodze mozna predykaty wciskac np.
        Predicate predicate = criteriaBuilder.like(from.get("topic"), "%kwant%");

        query.where(predicate);
        TypedQuery<Post> typedQuery = entityManager.createQuery(query.select(from));

        List<Post> result = typedQuery.getResultList();

        assertEquals(1, result.size());
        assertEquals("fizyka kwantowa", result.get(0).getTopic());
    }
}
