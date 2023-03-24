package springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.cruddemo.dao.StudentDAO;
import springboot.cruddemo.dao.StudentDAO2;
import springboot.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // When we declare the class,interface or method as a @Bean, Spring will automatically initialize or create a instance
	public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
		return runner ->{

			//createStudent(studentDAO);

			createMultipleStudents(theStudentDAO);
		};
	}


	private void createMultipleStudents(StudentDAO theStudentDAO) {

		// create multiple students
		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("john","Doe","john@doe");
		Student tempStudent2 = new Student("mary","public","mary@public");
		Student tempStudent3 = new Student("bonita","applebum","bonita@applebum");


		//save the student objects
		System.out.println("Saving the students");
		theStudentDAO.save(tempStudent1);
		theStudentDAO.save(tempStudent2);
		theStudentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO theStudentDAO) {

		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("paul","walker","paul@walker");

		// save the student object
		System.out.println("Saving student ...");
		theStudentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());


	}

}
