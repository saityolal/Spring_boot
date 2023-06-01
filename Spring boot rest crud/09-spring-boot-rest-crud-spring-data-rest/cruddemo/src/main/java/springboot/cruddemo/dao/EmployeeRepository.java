package springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  // first parameter for our entity type the other one is for the primary key
{
// will act as a DAO for us
// no need to write code, spring jpa will provide crud methods for free
// REST endpoint will be first character of entity name is lowercase and add "s" to end of entity name
}
