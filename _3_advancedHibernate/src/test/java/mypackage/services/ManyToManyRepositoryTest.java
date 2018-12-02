package mypackage.services;

import mypackage.models.Book;
import mypackage.models.BookAuthor;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyRepositoryTest {

    @Autowired
    private ManyToManyRepository manyToManyRepository;

    @Test
    public void getBookById() {
        Book book = manyToManyRepository.getBookById(1L);
        assertEquals("java in practice", book.getName());
        List<String> authors = book.getBookAuthors().stream()
                .map(BookAuthor::getName)
                .collect(Collectors.toList());

        assertThat(authors, Matchers.containsInAnyOrder("Joe", "Jane"));
    }
}