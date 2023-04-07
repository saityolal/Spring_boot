package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.cruddemo.entity.Student;

import java.util.List;


// This class is our data access object(DAO)

@Repository  //(@Component) Specialized annotation for repositories supports component scanning, translates JDBC exceptions
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
    @Transactional  //  For data consistency. They all execute or none of them executes
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id); // We need to indicate type of Entity that we are looking for
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student" ,Student.class); // first parameter is name of the JPA Entity which is JPQL, NOT the name of the DATABASE TABLE

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName = :theData" ,Student.class); // theData is a kind of placeholder

        // set query parameters
        theQuery.setParameter("theData", theLastName);


        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {

        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);
        //delete the student

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedRowNum = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRowNum;
    }

    @Override
    @Transactional
    public void deleteByLastName(String theLastName) {
        int deletedRowsNum;
        TypedQuery theQuery= entityManager.createQuery(
                "DELETE FROM Student WHERE lastName=:theData" ,Student.class
        );

        theQuery.setParameter("theData",theLastName);
        deletedRowsNum=theQuery.executeUpdate();
    }


}





