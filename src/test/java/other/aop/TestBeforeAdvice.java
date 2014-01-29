package other.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * User: yang
 * Date: 14-1-28 11:22
 */
public class TestBeforeAdvice {

    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(waiter);
        pf.addAdvice(advice);
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("king");
        proxy.serveTo("kernel");
    }
}
