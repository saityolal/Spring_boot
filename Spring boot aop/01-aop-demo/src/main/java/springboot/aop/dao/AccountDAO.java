package springboot.aop.dao;

import springboot.aop.Account;

public interface AccountDAO {
   void addAccount(Account theAccount, boolean vipFlag , int vipNo);
}
