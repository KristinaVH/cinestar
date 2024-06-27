package org.valentic.hodak.cinestar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CinestarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinestarApplication.class, args);
    }

}
