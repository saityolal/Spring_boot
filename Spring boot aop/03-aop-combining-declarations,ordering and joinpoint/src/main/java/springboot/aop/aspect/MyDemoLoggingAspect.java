package springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import springboot.aop.Account;

@Aspect
@Component
@Order(3)
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
//    @Before("execution(* springboot.aop.*.*.add*(springboot.aop.Account,..))")
//    @Before("execution(* springboot.aop.*.*.*(springboot.aop.Account,..))")


    @Before("springboot.aop.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // With JoinPoint we can catch parameters that were sent or make use of it
        System.out.println("\n===>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: " + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through the arguments
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) tempArg;  // downcast applied

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }

        }
    }



    @Before("springboot.aop.aspect.AopExpressions.gettersAndSetters()")
    public void exceptGettersAndSetters() {
        System.out.println("\n===>>> Executing @Before unless has getter or setter");
    }


}



