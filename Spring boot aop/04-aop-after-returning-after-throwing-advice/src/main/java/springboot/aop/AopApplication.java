package springboot.aop;

import springboot.aop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.aop.dao.MembershipDAO;

import java.util.List;

@SpringBootApplication

public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);

    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

        return runner -> {

            //theBeforeAdvice(theAccountDAO, theMembershipDAO);
            //theAfterReturningAdavice(theAccountDAO, theMembershipDAO);
            theAfterThrowingAdvice(theAccountDAO, theMembershipDAO);

        };
    }

    private void theAfterThrowingAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call method to find accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            accounts = theAccountDAO.findAccounts(tripWire);
        }
        catch(Exception exception){
            System.out.println("\n\n  Main app: ... caught exception: " + exception);

        }
        // display the accounts
        System.out.println("\n\n  Main app: theAfterThrowingAdvice");
        System.out.println("---");
        System.out.println(accounts);
    }

    private void theAfterReturningAdavice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call method to find accounts
        List<Account> accounts = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\n  Main app: theAfterReturningAdavice");
        System.out.println("---");
        System.out.println(accounts);
    }


    private void theBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO themMembershipDAO) {

        // call the business method
        Account myAccount = new Account();
        myAccount.setName("john");
        myAccount.setLevel("platinum");
        theAccountDAO.addAccount(myAccount, true, 1);
        theAccountDAO.deleteAccount(10);

        // call the account dao geters/setters methods
        theAccountDAO.setName("Paul");
        theAccountDAO.setServiceCode("gold");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // call the membership business membership method
        themMembershipDAO.addAccountBoolean();


    }


}
