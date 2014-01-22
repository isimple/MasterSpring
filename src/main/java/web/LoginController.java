package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.LoginCommand;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * User: yang
 * Date: 14-1-22
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
        boolean isValidate = userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if (!isValidate){
            return new ModelAndView("login","error","用户名或密码错误.");
        }else{
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }

    }

}
