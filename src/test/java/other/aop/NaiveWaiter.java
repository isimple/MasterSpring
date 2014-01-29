package other.aop;

/**
 * User: yang
 * Date: 14-1-28 11:20
 */
public class NaiveWaiter implements Waiter{
    @Override
    public void greetTo(String name) {
        System.out.println("greet to" + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to" + name + "...");
    }
}
