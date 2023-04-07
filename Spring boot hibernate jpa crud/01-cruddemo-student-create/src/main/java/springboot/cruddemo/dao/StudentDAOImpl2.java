package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.cruddemo.entity.Student;


// This class is our data access object(DAO)

@Repository  //(@Component) Specialized annotation for repositories supports componing scanning, translates JDBC exceptions

public class StudentDAOImpl2 implements StudentDAO2 {


    // define field for the entity manager
    private EntityManager entityManager;


    // inject the entity manager with constructor injection
    @Autowired
    public StudentDAOImpl2(EntityManager entityManager) {
        this.entityManager = entityManager;

        System.out.println("Proccess is done!!!!!!!!!!");
    }


    // implement save method
    @Override
    @Transactional  //  For data consistency. They all executes or none of them executes
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

}





