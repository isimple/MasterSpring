package other.aop.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * User: yang
 * Date: 14-1-28 23:00
 */
public class AspectJTest {

    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxyWaiter = factory.getProxy();
        proxyWaiter.serveTo("king");
        proxyWaiter.greetTo("kernel");
    }
}
