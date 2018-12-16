package mypackage.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransakcjeTest {
    @Autowired
    private EntityManager entityManager;
// transakcje zeby set operacji byl atomowy - albo uda sie wszystko albo nic



//    3 problemy
//    dirty read - 2 transakcje rownolegle zmieniaja cos, jedna sie nie udaje, druga leci dalej z niekatualnym stanem
//    non repeatable red - 2 transakcje, jedna select, druga update, jedna select. drugi select daje inny wynik
//    phantom read - jak wyzej, ale  dodanie wiersza. wtedy ilosc wynikow sie nie zgadza

    // strategie:       dirty read | non repeatable | phantom
//    read uncommited     :(            :(              :(
//    read comited        solved
//    repeatable read     solved        solved
//    serializable          solved wszystko

//    najczesciej read commited sie stosuje - bo dane sa w miare konsystentne

    // transactional - jpa - transakcje na jednej bazie
//    transactional - spring - wiele baz mozna robic, kolejki. Isolation tez tu
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Test
    public void test() {
        // given
        // when
        // then
    }
}