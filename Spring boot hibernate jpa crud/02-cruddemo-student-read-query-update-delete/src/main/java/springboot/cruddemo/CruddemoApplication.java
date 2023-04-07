package springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.cruddemo.dao.StudentDAO;
import springboot.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    // When we declare the class,interface or method as a @Bean, Spring will automatically initialize or create a instance
    public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
        return runner -> {

            //createStudent(studentDAO);

            // createMultipleStudents(theStudentDAO);

            //readStudent(theStudentDAO);

            // queryForStudent(theStudentDAO);

            //queryForStudentByLastName(theStudentDAO);

            // updateStudent(theStudentDAO);

            //deleteStudent(theStudentDAO);

            deleteAllStudents(theStudentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO theStudentDAO) {
        try {
            int result = theStudentDAO.deleteAll();
            System.out.println("number of deleted rows = " + result);
        }catch (Exception e) {System.out.println("error deleting:"+ e);}
    }

    private void deleteStudent(StudentDAO theStudentDAO) {

        try {
            int studentId = 1;
            System.out.println("Getting Student:\n");
            Student myStudent = theStudentDAO.findById(studentId);
            System.out.println("deleting student:\n" + myStudent);
            theStudentDAO.delete(3);
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }

    }


    private void updateStudent(StudentDAO theStudentDAO) {

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting Student:\n");
        Student myStudent = theStudentDAO.findById(studentId);
        System.out.println("Before Update: " + myStudent);

        // change first name
        myStudent.setFirstName("The Rock");

        // update the student
        theStudentDAO.update(myStudent);

        // display updated student
        System.out.println("After Update: " + myStudent);
    }

    private void queryForStudentByLastName(StudentDAO theStudentDAO) {

        // get a list of students
        List<Student> theStudents = theStudentDAO.findByLastName("doe");

        // display list of students
        for (Student tempStudent : theStudents) {

            System.out.println(tempStudent);
        }
    }

    private void queryForStudent(StudentDAO theStudentDAO) {

        // get a list of students
        List<Student> theStudents = theStudentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO theStudentDAO) {
        // create  a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Walker", "paul@walker.com");

        // save the student
        System.out.println("Saving the student ...");
        theStudentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = theStudentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }


    private void createMultipleStudents(StudentDAO theStudentDAO) {

        // create multiple students
        System.out.println("Creating 3 student object");
        Student tempStudent1 = new Student("john", "Doe", "john@doe");
        Student tempStudent2 = new Student("mary", "public", "mary@public");
        Student tempStudent3 = new Student("bonita", "applebum", "bonita@applebum");


        //save the student objects
        System.out.println("Saving the students");
        theStudentDAO.save(tempStudent1);
        theStudentDAO.save(tempStudent2);
        theStudentDAO.save(tempStudent3);


    }

    private void createStudent(StudentDAO theStudentDAO) {

        // create the student object
        System.out.println("Creating new student object");
        Student tempStudent = new Student("paul", "walker", "paul@walker");

        // save the student object
        System.out.println("Saving student ...");
        theStudentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());


    }


}
