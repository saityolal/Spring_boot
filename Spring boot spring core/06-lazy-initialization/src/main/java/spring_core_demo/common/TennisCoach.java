package spring_core_demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {


    public TennisCoach(){

        System.out.println("In constructor:  " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley";
    }
}
