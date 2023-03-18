package spring_core_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_core_demo.common.Coach;
import spring_core_demo.common.SwimCoach;

@Configuration
public class SportConfig {

    @Bean("foo")
    public Coach swimCoach(){  // The Bean id defaults  to the  method name
        return new SwimCoach();
    }
}
