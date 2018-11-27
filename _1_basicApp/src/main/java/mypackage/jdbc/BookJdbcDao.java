package mypackage.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


// spring jdbc - nie ma adnotacji @entity nawet

@Repository
public class BookJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BookJdbc> findAll() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(BookJdbc.class));
    }
}
