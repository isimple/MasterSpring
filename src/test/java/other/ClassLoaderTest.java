package other;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * User: yang
 * Date: 14-1-23
 */
public class ClassLoaderTest {

    @Test
    public void testClassLoader1(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }

    @Test
    public void testResourceClass() throws Exception{
        //ClassPathResource / ServletContextResource为WEB根目录
        //支持classpath: ; file: ; ? ; * ; **
        String path = " D:/dsf/dsfsdf.txt";
        Resource resource1 = new FileSystemResource(path);
        //resource1.createRelative("nihao.xdf");
        System.out.println(resource1.getFilename());
        System.out.println(resource1.getFile().getPath());
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath:*.xml");//support ant-style path
        for(Resource resource : resources){
            System.out.println(resource.getDescription());
        }
       // new ClassPathXmlApplicationContext()
    }

}
