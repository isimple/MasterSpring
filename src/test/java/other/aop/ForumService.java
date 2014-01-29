package other.aop;

/**
 * User: yang
 * Date: 14-1-26 23:48
 */
public class ForumService {
    public void remote(int id){
        System.out.println("模拟删除记录," + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
