package com.chukurs.aopdemo;

import com.chukurs.aopdemo.dao.AccountDAO;
import com.chukurs.aopdemo.dao.MemberShipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {

        return runner -> {
            demoTheBeforeAdviceAccount(accountDAO);
            demoTheBeforeAdviceMember(memberShipDAO);

        };
    }

    private void demoTheBeforeAdviceAccount(AccountDAO accountDAO) {

        accountDAO.addAccount(new Account("matiss","5th level"),false);
    }

    private void demoTheBeforeAdviceMember(MemberShipDAO memberShipDAO) {

        memberShipDAO.addAccount();
    }
}
