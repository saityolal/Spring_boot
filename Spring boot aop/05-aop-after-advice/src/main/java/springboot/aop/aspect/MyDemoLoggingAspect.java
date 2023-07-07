package springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import springboot.aop.Account;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @After("execution(* springboot.aop.*.*.*(..))") // @After will be executed regardless of your code fails or succeeds
    public void AfterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
        // print out which method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @After (finally) advice on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* springboot.aop.*.*.*(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @AfterThrowing advice on method: " + method);
        // log the exception
        System.out.println("\n===>>> The Exception is: " + theExc);
    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* springboot.aop.*.*.*(..))",
            returning = "result")
    public void afterFindAccount(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @AfterReturning advice on method: " + method);

        // print out the result of the method call
        System.out.println("\n===>>> result is" + result);

        // let's post-process the data - modify it

        // covert the account names to uppercase
        covertAccountNamesToUpperCase(result);

        System.out.println("\n===>>> uppercase version result  is" + result);

    }

    private void covertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {
            // get uppercase version of name
            String accountName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(accountName);

        }


    }


    @Before("springboot.aop.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // With JoinPoint we can catch parameters that were sent or make use of it
        System.out.println("\n===>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("\nMethod Signature: " + methodSignature);

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



