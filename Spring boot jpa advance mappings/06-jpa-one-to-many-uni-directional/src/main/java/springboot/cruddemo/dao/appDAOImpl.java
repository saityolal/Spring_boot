package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.cruddemo.entity.Course;
import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;

import java.util.List;

@Repository
public class appDAOImpl implements appDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor
    @Autowired
    public appDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);

    }


    @Override
    public Instructor findInstructorById(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get courses
        List<Course> tempCourses = tempInstructor.getCourses();

        // break the association of courses for the instructor
         for (Course course : tempCourses) {
             course.setInstructor(null);
         }

        //  delete instructor
        entityManager.remove(tempInstructor); // This will ALSO delete the instructor details object Because of CascadeType.ALL in Instructor entity

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);  // have to break the association unless got an error because of the foreign key

        // delete the instructorDetail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        TypedQuery<Instructor> query =entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);   // need to be careful about blanks while using + operation
        query.setParameter("data", theId);

        Instructor tempInstructor = query.getSingleResult();

        return tempInstructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    public Course findCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class, theId);

        return tempCourse;

    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);

    }

    @Override
    @Transactional
    public void deleteCourseByid(int theId) {
        // retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCoruseId(int theId) {

        // create a query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                "JOIN FETCH c.reviews " +
                "where c.id = :data", Course.class);

        query.setParameter("data", theId);

        // execute the query
        Course course = query.getSingleResult();

        return course;
    }
}
