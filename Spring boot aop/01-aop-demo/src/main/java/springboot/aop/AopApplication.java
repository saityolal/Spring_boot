package springboot.aop;

import springboot.aop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.aop.dao.MembershipDAO;

@SpringBootApplication

public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);

	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			theBeforeAdvice(theAccountDAO, theMembershipDAO);
			

		};
	}

	private void theBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO themMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true,1);

		themMembershipDAO.addAccountBoolean();


	}



}
