package springboot.aop.dao;

import org.springframework.stereotype.Repository;
import springboot.aop.Account;

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
    public void addAccount(Account theAccount, boolean vipFlag, int vipNo) {
        System.out.println("\n"+getClass() + "  Doing my db work");
    }

    @Override
    public void deleteAccount(int id) {
        System.out.println("\n"+getClass() + "  Deleting account");

    }
}
