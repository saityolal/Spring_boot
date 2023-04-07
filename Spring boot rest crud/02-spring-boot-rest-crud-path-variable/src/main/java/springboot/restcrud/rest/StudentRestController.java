package springboot.restcrud.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    return theStudents.get(studentId);}



}
