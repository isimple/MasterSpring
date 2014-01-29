package other.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: yang
 * Date: 14-1-26 23:56
 */
public class PerformanceHandler implements InvocationHandler{

    private Object target;

    public PerformanceHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
