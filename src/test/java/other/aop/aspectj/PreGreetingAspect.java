package other.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * User: yang
 * Date: 14-1-28 22:53
 */
@Aspect
public class PreGreetingAspect {

    //greetTo方法进行切面，返回值任意，参数也任意
    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("How are you. ");
    }
}
