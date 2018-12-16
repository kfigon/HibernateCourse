package mypackage.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CacheTest {
//    pierwszy poziom kesza - persistance context kazdej transakcji
//  2 ready tego samego nie striggeruja selecta

//    drugi - wszystkie transakcje

//    sterowanie (szczegolnie second level) - EhCache z hibernate
    @Test
    public void asd () {
    }
}
