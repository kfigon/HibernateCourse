package mypackage.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


// spring jdbc - nie ma adnotacji @entity nawet
// w JDBC piszemy query zawsze, potem mapping

// legacy jdbc jest trudniejsze, trzeba pilnowac polaczenia, transakcji, recznie mapowac itd.

@Repository
public class BookJdbcDao {

    // to laczy sie z baza
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BookJdbc> findAll() {
        return jdbcTemplate.query("select * from book",
                new BeanPropertyRowMapper<>(BookJdbc.class)); // mozna robic customowe mappery (jesli np. nazwy kolumn sa inne)
    }

    public BookJdbc findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from book where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(BookJdbc.class));
    }
}
