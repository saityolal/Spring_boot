package springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){


        return "fancy-login";
    }

    // create access denied page
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){


        return "access-denied";
    }
}