package springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup Logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    // add before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @Before: calling method " + method);

        // display the arguments to the method
        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through and display arguments
        for (Object arg : args) {
            myLogger.info("=====> argument " + arg);
        }

    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    private void afterReturning(JoinPoint theJoinPoint, Object result) {

        // display method we are returning from
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @AfterReturning: from method " + method);

        // display data returned
        myLogger.info("=====> result:" + result);

    }


}
