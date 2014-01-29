package other.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * User: yang
 * Date: 14-1-28 22:01
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements  Monitorable{

    private ThreadLocal<Boolean> montiorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        montiorStatusMap.set(active);
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable{

        return null;
    }
}
