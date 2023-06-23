package springboot.cruddemo.dao;

import springboot.cruddemo.entity.Course;
import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface appDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void  deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor tempInstructor);

    Course findCourseById(int theId);
    void updateCourse(Course tempCourse);

    void deleteCourseByid(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCoruseId(int theId);
}
