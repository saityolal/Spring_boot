package springboot.cruddemo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.cruddemo.dao.appDAO;
import springboot.cruddemo.entity.Course;
import springboot.cruddemo.entity.Instructor;
import springboot.cruddemo.entity.InstructorDetail;
import springboot.cruddemo.entity.Review;

import java.util.List;

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
            //  deleteInstructor(theAppDAO);
            // findInstructorDetail(theAppDAO);
            // deleteInstructorDetail(theAppDAO);
            // createInstructorWithCourses(theAppDAO);
            // findInstructorWithCourses(theAppDAO);
            // findCoursesForInstructor(theAppDAO);
            //  findInstructorWithCoursesJoinFetch(theAppDAO);
            //   updateInstructor(theAppDAO);
            //   updateCourse(theAppDAO);
            // deleteCourse(theAppDAO);
            //  createCourseAndReviews(theAppDAO);
            //  retrieveCourseAndReviews(theAppDAO);
            deleteCourseAndReviews(theAppDAO);
        };
    }

    private void deleteCourseAndReviews(appDAO theAppDAO) {
        int theId = 10;
        System.out.println("Deleting Course Id: " + theId);
        theAppDAO.deleteCourseByid(theId);
        System.out.println("course and associated reviews have been deleted!");
    }

    private void retrieveCourseAndReviews(appDAO theAppDAO) {
        int theId = 10;
        System.out.println("Finding Course : " + theId);
        Course tempCourse = theAppDAO.findCourseAndReviewsByCoruseId(theId);

        System.out.println("Course Found : " + tempCourse);
        System.out.println("Associated reviews : " + tempCourse.getReviews());


    }


    private void createCourseAndReviews(appDAO theAppDAO) {

        // create a course
        Course tempCourse = new Course("Pacman - How to score 1M points");

        // add some reviews
        tempCourse.addReview(new Review("Great course love it"));
        tempCourse.addReview(new Review("Cool course job well done"));
        tempCourse.addReview(new Review("Did not help at all"));

        // save the course
        System.out.println("Saving the course and reviews");
        theAppDAO.save(tempCourse);
        System.out.println("Course: " + tempCourse);
        System.out.println("Reviews: " + tempCourse.getReviews());
    }

    private void deleteCourse(appDAO theAppDAO) {
        int theId = 11;
        //find Course
        System.out.println("Deleting Course id: " + theId);

        // delete the course
        theAppDAO.deleteCourseByid(theId);
        System.out.println("DONE!");
    }

    private void updateCourse(appDAO theAppDAO) {
        int theId = 10;
        // find the course
        System.out.println("Finding Course : " + theId);
        Course tempCourse = theAppDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating Course : " + tempCourse);
        tempCourse.setTitle("Enjoy the simple things");

        theAppDAO.updateCourse(tempCourse);
        System.out.println("DONE!");
    }


    private void updateInstructor(appDAO theAppDAO) {
        int theId = 1;

        // find instructor
        System.out.println("Finding instructor: " + theId);
        Instructor theInstructor = theAppDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id : " + theId);

        theInstructor.setLastName("TESTER");

        theAppDAO.updateInstructor(theInstructor);

        System.out.println("DONE!");
    }

    private void findInstructorWithCoursesJoinFetch(appDAO theAppDAO) {
        int theId = 1;
        // find instructor
        System.out.println("instructor finding: " + theId);

        Instructor tempInstructor = theAppDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("The instructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Finding the instructor with JOIN FETCH DONE!");


    }


    private void findCoursesForInstructor(appDAO theAppDAO) {
        int theId = 1;

        // find insturctor
        System.out.println("finding instructor id: " + theId);

        Instructor tempInstructor = theAppDAO.findInstructorById(theId);

        System.out.println("tempInstructor:  " + tempInstructor);


        // find courses for instructor
        System.out.println("finding courses for instructor id: " + theId);
        List<Course> courses = theAppDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("Associated Courses: " + tempInstructor.getCourses());

    }

    private void findInstructorWithCourses(appDAO theAppDAO) {
        int theId = 1;
        System.out.println("finding instructor id: " + theId);

        Instructor tempInstructor = theAppDAO.findInstructorById(theId);

        System.out.println("Associated courses: " + tempInstructor.getCourses());

    }

    private void createInstructorWithCourses(appDAO theAppDAO) {

        Instructor tempInstructor = new Instructor("susan", "public", "sus@pub");


        InstructorDetail tempInstructorDetail = new InstructorDetail("susan@youtube.com", "Video games");


        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course temCourse1 = new Course("Air Guitar - Ultimate Guide");
        Course temCourse2 = new Course("The Pinball Masterclass");

        tempInstructor.addCourse(temCourse1);
        tempInstructor.addCourse(temCourse2);

        // save the instructor
        System.out.println("Saving instructor with courses" + tempInstructor);
        System.out.println("The courses" + tempInstructor.getCourses());
        theAppDAO.save(tempInstructor);


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

        int theId = 1;


        theAppDAO.deleteInstructorById(1);
        System.out.println("Instructor number " + theId + " deleted successfully");

        // when we deleted the instructor also we deleted the instructor detail because of CascadeType.ALL in Instructor entity
    }

    private void deleteInstructorDetail(appDAO theAppDAO) {

        int id = 5;
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


        Instructor tempInstructor = new Instructor("instructor", "chad", "ins@chad");


        InstructorDetail tempInstructorDetail = new InstructorDetail("chad@youtube", "hangout with his students");


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
