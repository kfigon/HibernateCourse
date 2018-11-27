package mypackage.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jdbc")
public class BookJdbcController {

    @Autowired
    private BookJdbcDao bookJdbcDao;

    @GetMapping("/books")
    public List<BookJdbc> getAllBooks() {
        return bookJdbcDao.findAll();
    }

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
