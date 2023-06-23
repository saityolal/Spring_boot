package springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.cruddemo.dao.appDAO;
import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(appDAO theAppDAO) { // this will be executed after spring beans have been loaded

        return runner -> {
           // createInstructor(theAppDAO);
           // findInstructor(theAppDAO);
           // deleteInstructor(theAppDAO);
           // findInstructorDetail(theAppDAO);
           // deleteInstructorDetail(theAppDAO);
        };
    }

    private void findInstructorDetail(appDAO theAppDAO) {

        // get the Instructor detail object
        int id = 1;
        InstructorDetail theInstructorDetail = theAppDAO.findInstructorDetailById(id);

        // print the instructor detail
        System.out.println("Instructor details coming out: " + theInstructorDetail);

        // print the associated instructor
        System.out.println("Associated instructor:  " + theInstructorDetail.getInstructor());


    }

    private void deleteInstructor(appDAO theAppDAO) {

        int theId = 2;



        theAppDAO.deleteInstructorById(2);
        System.out.println("Instructor number " + theId + " deleted successfully");
    }

    private void deleteInstructorDetail(appDAO theAppDAO) {

        int id = 1;
        theAppDAO.deleteInstructorDetailById(id);
        System.out.println("Instructor number " + id + " deleted successfully");
    }

    private void findInstructor(appDAO theAppDAO) {
        int id = 1;

        Instructor tempInstructor = theAppDAO.findInstructorById(id);

        System.out.println("Instructor found: " + tempInstructor + "\n");
        System.out.println("Instructor details: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(appDAO theAppDAO) {
		/*
		// create the instructor
		Instructor tempInstructor = new Instructor("Paul","Walker","paul@walker");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("paul@youtube","hangout with his car");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		*/


		Instructor tempInstructor = new Instructor("instructor","chad","ins@chad");


		InstructorDetail tempInstructorDetail = new InstructorDetail("chad@youtube","hangout with his students");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // This will also save the details object
        // because of CascadeType.ALL
        //

        System.out.println("Saving instructor: " + tempInstructor);

        theAppDAO.save(tempInstructor);

    }


}
