package web.mobileleleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class MobileleleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileleleAppApplication.class, args);
    }

}
