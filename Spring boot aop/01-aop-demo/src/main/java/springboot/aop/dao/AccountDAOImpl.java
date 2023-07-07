package springboot.aop.dao;

import org.springframework.stereotype.Repository;
import springboot.aop.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {


    @Override
    public void addAccount(Account theAccount, boolean vipFlag, int vipNo) {
        System.out.println(getClass() + "  Doing my db work");
    }
}
