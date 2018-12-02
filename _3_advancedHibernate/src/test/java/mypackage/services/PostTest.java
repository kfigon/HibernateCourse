package mypackage.services;


import mypackage.models.Order;
import mypackage.models.OrderItem;
import mypackage.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void savePost() {
        Post post = new Post();
        post.setTopic("some topic");

        entityManager.persist(post);

        assertNotNull(post.getId());
    }

    @Transactional
    @Test
    public void readOrders() {
        Order order = entityManager.find(Order.class, 1L);
        assertEquals("stuff", order.getName());
        assertEquals(3, order.getItems().size());

        List<OrderItem> items = order.getItems();
        items.forEach(item -> assertEquals(order.getId(), item.getOrder().getId()));
    }
}