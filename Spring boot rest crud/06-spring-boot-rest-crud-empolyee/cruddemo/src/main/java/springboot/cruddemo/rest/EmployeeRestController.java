package springboot.cruddemo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.cruddemo.dao.EmployeeDAO;
import springboot.cruddemo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO theEmployeeDAO;

    // quick and dirty:  Inject the employee dao (using constructor injection)
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }
}
