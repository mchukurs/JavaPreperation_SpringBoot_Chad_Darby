package com.chukurs.aopdemo;

import com.chukurs.aopdemo.dao.AccountDAO;
import com.chukurs.aopdemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {

        return runner -> {
            // demoTheBeforeAdviceAccount(accountDAO);
            // demoTheBeforeAdviceMember(memberShipDAO);
            //accountDAO.setName("testName");
            //  accountDAO.setServiceCode("testServiceName");
            //  accountDAO.getName();
            //demoTheAfterThrowingAdviceAccount(accountDAO);
           // demoTheAfterAdviceAccount(accountDAO);
            demoTheAroundAdviceAccount(accountDAO);

        };
    }

    private void demoTheAroundAdviceAccount(AccountDAO accountDAO) {
        List<Account> a = accountDAO.findAccounts(false);
        System.out.println(a);
    }

//    private void demoTheAfterAdviceAccount(AccountDAO accountDAO) {
//        var a = accountDAO.findAccounts(true);
//
//
//    }
//
//    private void demoTheBeforeAdviceAccount(AccountDAO accountDAO) {
//
//        accountDAO.addAccount(new Account("matiss", "5th level"), false);
//        accountDAO.doWork();
//    }
//
//    private void demoTheAfterReturningAdviceAccount(AccountDAO accountDAO) throws Exception {
//        System.out.println("line before findAccounts");
//        var a = accountDAO.findAccounts(false);
//        System.out.println(a);
//
//    }
//
//    private void demoTheAfterThrowingAdviceAccount(AccountDAO accountDAO) throws Exception {
//        var a = accountDAO.findAccounts(true);
//
//
//
//    }
//
//    private void demoTheBeforeAdviceMember(MemberShipDAO memberShipDAO) {
//
//        memberShipDAO.addAccount();
//    }
}
