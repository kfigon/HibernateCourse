package mypackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    mozna polaczyc sie z konsola
    // localhost:8080/h2-console
//    trzeba urla wpisac jdbc:h2:mem:testdb
}
