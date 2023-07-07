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
		myAccount.setName("john");
		myAccount.setLevel("platinum");
		theAccountDAO.addAccount(myAccount,true,1);
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
