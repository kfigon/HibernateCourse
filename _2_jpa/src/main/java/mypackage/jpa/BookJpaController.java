package mypackage.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jpa")
public class BookJpaController {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @GetMapping("/books")
    public List<BookJpa> getAll() {
        return bookJpaRepository.getAll();
    }

    @GetMapping("/booksx")
    public List<BookJpa> getAllx() {
        return bookJpaRepository.getAllNamedQuery();
    }

    @GetMapping("/{id}")
    public BookJpa findById(@PathVariable Integer id) {
        return bookJpaRepository.findById(id);
    }
}
