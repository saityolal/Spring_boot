package springboot.aop.dao;

import springboot.aop.Account;

public interface AccountDAO {
   void addAccount(Account theAccount, boolean vipFlag , int vipNo);
   void deleteAccount(int id);

   public String getName();

   public void setName(String name);


   public String getServiceCode();
   public void setServiceCode(String serviceCode);

}
