package springboot.cruddemo.dao;

import springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void deleteByLastName(String theLastName);

    void delete(int id);

    int deleteAll();

}
