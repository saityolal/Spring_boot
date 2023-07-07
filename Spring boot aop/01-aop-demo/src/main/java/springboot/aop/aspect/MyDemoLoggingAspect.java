package springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // Attention! you can't use * instead of full-package-path However you can use like java.myProject.*

    // public(no need to write) - return type - packagePath - class - method - paramType(with path)

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void springboot.aop.dao.AccountDAO.addAccount())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*(springboot.aop.Account))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* *.add*(..))")
//    @Before("execution(* springboot.aop.dao.*.add*(springboot.aop.Account))")
//    @Before("execution(* *.add*(springboot.aop.Account))")
//    @Before("execution(* *.add*(springboot.aop.Account, boolean, int, ..))")
    @Before("execution(* springboot.aop.*.*.add*(springboot.aop.Account,..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }
}
