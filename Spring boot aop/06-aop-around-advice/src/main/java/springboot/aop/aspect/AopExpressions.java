package springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  // if you only have Poincuts then @Aspect is optional. Only required if you add advices in the class: @Before, @After etc..
@Component
public class AopExpressions {

    // Other aspect class function can access pointcut expressions

    @Pointcut("execution(* springboot.aop.dao.*.*(..))") // that's Pointcut declaration and can have any name
    public void forDaoPackage() {
    }


    @Pointcut("execution(* springboot.aop.*.*.get*(..))")
    public void forGetters() {
    }

    @Pointcut("execution(* springboot.aop.*.*.set*(..))")
    public void forSetters() {
    }

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
    public void gettersAndSetters() {

    }
}
