package springboot.aop.dao;

import org.springframework.stereotype.Repository;
import springboot.aop.Account;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    public String getName() {
        System.out.println("\n"+getClass() + "  in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("\n"+getClass() + "  in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("\n"+getClass() + "  in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("\n"+getClass() + "  in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // add academic purposes .. simulate an exception
        if(tripWire == true){
            throw new RuntimeException("BOOM!  Your code failed!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create simple accounts
        Account tempAccount1 = new Account("Mary", "Silver");
        Account tempAccount2 = new Account("Susan", "Gold");
        Account tempAccount3 = new Account("Luca", "Platinum");

        // add them to our accounts list
        myAccounts.add(tempAccount1);
        myAccounts.add(tempAccount2);
        myAccounts.add(tempAccount3);

        return myAccounts;

    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag, int vipNo) {
        System.out.println("\n"+getClass() + "  Doing my db work");
    }

    @Override
    public void deleteAccount(int id) {
        System.out.println("\n"+getClass() + "  Deleting account");

    }
}
