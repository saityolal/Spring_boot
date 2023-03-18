package spring_core_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_core_demo.common.Coach;

@RestController
//     Spring @Controller annotation is  a specialization of @Component annotation. It’s used to mark a class as a web request handler.
public class DemoController {

    // define a private  field for the  dependency
    private Coach myCoach;

    //  define a constructor for the dependency injection
    @Autowired
    DemoController(Coach theCoach) {

        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}

