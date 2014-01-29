package other.aop;

/**
 * User: yang
 * Date: 14-1-26 23:53
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse  = end - begin;
        System.out.println(serviceMethod + "costed " + elapse + " 毫秒.");
    }
}
