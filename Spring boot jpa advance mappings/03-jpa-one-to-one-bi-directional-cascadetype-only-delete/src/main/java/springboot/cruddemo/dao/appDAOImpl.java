package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;

@Repository
public class appDAOImpl implements appDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor
    @Autowired
    public appDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);

    }



    @Override
    public Instructor findInstructorById( int theId) {

       Instructor tempInstructor = entityManager.find(Instructor.class,theId);

       return tempInstructor;
    }

    @Override
   @Transactional
    public void deleteInstructorById(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class,theId);


        entityManager.remove(tempInstructor); //This will ALSO delete the instructor details object Because of CascadeType.ALL

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        // remove the associated object reference
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructorDetail
        entityManager.remove(tempInstructorDetail);
    }
}
