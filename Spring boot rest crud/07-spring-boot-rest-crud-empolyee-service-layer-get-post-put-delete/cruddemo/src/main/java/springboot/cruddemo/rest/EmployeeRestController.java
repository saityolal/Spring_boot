package springboot.cruddemo.rest;


import org.springframework.web.bind.annotation.*;
import springboot.cruddemo.dao.EmployeeDAO;
import springboot.cruddemo.entity.Employee;
import springboot.cruddemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService theEmployeeService;

    // quick and dirty:  Inject the employee dao (using constructor injection)
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.theEmployeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return theEmployeeService.findAll();
    }

    // add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = theEmployeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Could not find employee" + employeeId);

        }

        return theEmployee;
    }

    // add maping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead f update
        theEmployee.setId(0);

        Employee dbEmployee = theEmployeeService.save(theEmployee);
        return dbEmployee;
    }

    // add maping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = theEmployeeService.save(theEmployee);

        return dbEmployee;
    }

    // add maping for DELETE /employees - delete existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = theEmployeeService.findById(employeeId);

        // throw exception if null
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found" + employeeId);
        }
        theEmployeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
