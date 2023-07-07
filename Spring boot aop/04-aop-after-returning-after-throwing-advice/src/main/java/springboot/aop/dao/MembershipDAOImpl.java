package springboot.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {


    @Override
    public boolean addAccountBoolean() {
        System.out.println("\n"+getClass() + "  Adding a membership account");
        return false;
    }
}
