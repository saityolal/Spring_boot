package springboot.cruddemo.service;

import springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);
}
