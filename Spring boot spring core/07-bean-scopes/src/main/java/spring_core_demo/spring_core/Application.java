package spring_core_demo.spring_core;

import org.springframework.boot.SpringApplication; // Creates application context, and registers all beans, Starts the embedded server Tomcat etc...
import org.springframework.boot.autoconfigure.SpringBootApplication; /*	Enables Auto configuration, Component scanning, Additional configuration		*/

@SpringBootApplication(
        scanBasePackages = {"spring_core_demo",
                "util"
        }
)
//@SpringBootApplication
public class Application { // Bootstrap your Spring Boot application

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
