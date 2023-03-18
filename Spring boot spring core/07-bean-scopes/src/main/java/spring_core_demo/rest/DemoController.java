package spring_core_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_core_demo.common.Coach;

@RestController
// Spring @Controller annotation is  a specialization of @Component annotation. It’s used to mark a class as a web request handler.
public class DemoController {

    // define a private  field for the  dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach theCoach ,
                          @Qualifier("cricketCoach")Coach theAnotherCoach) {   // @Qualifier annotation has more priority than @Primary annotation

        System.out.println("In constructor:" + this.getClass().getSimpleName());

        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "Comparing beans:  myCoach == anotherCoach  :  " + (myCoach == anotherCoach);
    }
}

