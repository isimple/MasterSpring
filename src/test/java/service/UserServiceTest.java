package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: yang
 * Date: 14-1-22
 */
@RunWith(SpringJUnit4ClassRunner.class)//spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser() throws Exception {
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","123456432");
        assertTrue(b1);
        assertFalse(b2);
    }

    @Test
    public void testFindUserByUserName() throws Exception {

    }

    @Test
    public void testLoginSuccess() throws Exception {

    }
}
