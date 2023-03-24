package springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.cruddemo.dao.StudentDAO;
import springboot.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO){
		return runner ->{

			saveStudent(theStudentDAO);
		};
	}

public void saveStudent(StudentDAO theStudentDAO){

		Student tempStudent = new Student("blabla","blabla", "blabla" );

		theStudentDAO.save(tempStudent);
}



}
