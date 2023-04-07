package springboot.restcrud.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.restcrud.entity.Student;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents = new ArrayList<Student>();

    // define @PostConstructor to load the student data ... only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Marry", "Smith"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}") // This studentId and the parameter one should match
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        // check the studentId again list size

        if (studentId >= theStudents.size() || studentId < 0) {

            throw new StudentNotFoundException("Student Id Not Found - " + studentId);
        }


        return theStudents.get(studentId);
    }


    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        // return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // add another exception handler to catch any exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Please enter the right id of the student");
        error.setTimeStamp(System.currentTimeMillis());


        // return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
