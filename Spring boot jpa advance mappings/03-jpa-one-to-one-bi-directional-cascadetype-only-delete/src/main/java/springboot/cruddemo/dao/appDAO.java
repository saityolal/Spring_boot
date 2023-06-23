package springboot.cruddemo.dao;

import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;

public interface appDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void  deleteInstructorDetailById(int theId);
}
