package mypackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Arrays.asList(
                Book.builder().id(1).author("Lem").title("ASD").build(),
                Book.builder().id(2).author("Dick").title("zxc").build(),
                Book.builder().id(3).author("Tolkien").title("SAD").build()
        );
    }

    @GetMapping
    public String hello() {
        return "Hello!";
    }
}
