package springboot.aop.dao;

import springboot.aop.Account;

import java.util.List;

public interface AccountDAO {
   void addAccount(Account theAccount, boolean vipFlag , int vipNo);
   void deleteAccount(int id);

   public String getName();

   public void setName(String name);


   public String getServiceCode();
   public void setServiceCode(String serviceCode);

   public List<Account> findAccounts();

   List<Account> findAccounts(boolean tripWire);
}
