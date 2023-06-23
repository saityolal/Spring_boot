package springboot.cruddemo.dao;

import springboot.cruddemo.entity.Instructor;

public interface appDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);
}
