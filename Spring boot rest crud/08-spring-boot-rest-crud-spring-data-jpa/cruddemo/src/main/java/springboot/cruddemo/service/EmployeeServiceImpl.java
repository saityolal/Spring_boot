package springboot.cruddemo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.cruddemo.dao.EmployeeRepository;
import springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Couldn't find the employee" + theId);
        }

        return theEmployee;
    }

    //Jpa Repository provide @Transactional automatically
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //@Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
