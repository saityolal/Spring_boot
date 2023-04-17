package springboot.cruddemo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.cruddemo.dao.EmployeeDAO;
import springboot.cruddemo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO theEmployeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {

        return theEmployeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return theEmployeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return theEmployeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
         theEmployeeDAO.deleteById(theId);
    }
}
