package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.cruddemo.entity.Student;


// This class is our data access object(DAO)

@Repository  //(@Component) Specialized annotation for repositories supports componing scanning, translates JDBC exceptions
/* It is used to indicate whether the bean is a DAO or persistence class.
if this is the only bean then automatically will be injected so it's gonna be initiated */
@Primary
public class StudentDAOImpl implements StudentDAO {


    // define field for the entity manager
    private EntityManager entityManager;


    // inject the entity manager with constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }


    // implement save method
    @Override
    @Transactional  //  For data consistency. They all executes or none of them executes
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

}





