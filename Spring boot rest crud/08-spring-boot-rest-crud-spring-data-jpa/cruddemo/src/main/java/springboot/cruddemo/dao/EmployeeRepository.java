package springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.cruddemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>  // firs parameter for our entity type the other one is for the primary key
{
// will act as a DAO for us
// no need to write code, spring jpa will provide crud methods for free
}
