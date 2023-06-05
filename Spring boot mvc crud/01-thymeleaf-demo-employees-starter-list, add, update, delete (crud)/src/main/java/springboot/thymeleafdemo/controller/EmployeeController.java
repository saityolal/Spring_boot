package springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.thymeleafdemo.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springboot.thymeleafdemo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {



	private EmployeeService employeeService;

	@Autowired //optional because its only one constructor
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

/*
	// load employee data

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {

		// create employees
		Employee emp1 = new Employee("Leslie", "Andrews", "leslie@andrews");
		Employee emp2 = new Employee("Emma", "Baumgarten", "emma@baumgarten");
		Employee emp3 = new Employee("Avani", "Gupta", "avani@gupta");

		// create the list
		theEmployees = new ArrayList<>();

		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
*/
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees =employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees"; // spring will add .html end of it
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		// create model attiribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel){   // request param is used to bind html parameters

		// get the employee from the service
		Employee theEmployee = employeeService.findById(id);

		// set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);  // This model provides us to pre-show filled fields

		// send over to our form
		return "employees/employee-form";


	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeId){

		employeeService.deleteById(employeeId);

		return "redirect:/employees/list";
	}
}










