package com.chukurs.aopdemo;

import com.chukurs.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {

        return runner -> {
            demoTheBeforeAdivce(accountDAO);


        };
    }

    private void demoTheBeforeAdivce(AccountDAO accountDAO) {

        accountDAO.addAccount();
    }
}
