package cn.kgc.tangcco.appinfosys.controller.developer;

import cn.kgc.tangcco.appinfosys.pojo.DevUser;
import cn.kgc.tangcco.appinfosys.service.devuser.DevUserService;
import cn.kgc.tangcco.appinfosys.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/devlogin")
public class DevLoginController {

    @Resource
    private DevUserService devUserService;
    /**
     * 去开发者登陆页面
     *
     */
    @RequestMapping("/toLogin")
    public String toDevLogin(){
        return "devlogin";
    }


    /**
     * 开发者登陆
     */
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(String devCode, String devPassword, HttpSession session, HttpServletRequest request){
        try {
            DevUser devUser = devUserService.login(devCode,devPassword);
            System.out.println(devCode);
            if (devUser != null){
                //说明登陆成功,将用户存储到sessiong作用域
                session.setAttribute(Constants.DEV_USER_SESSION,devUser);
                return "developer/main";
            }else {//登陆失败
                request.setAttribute("error","登陆失败,用户名或密码错误");
                return "devlogin";
            }
        } catch (Exception e) {//登陆失败
            e.printStackTrace();
            request.setAttribute("error","登陆失败,用户名或密码错误");
            return "devlogin";
        }
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logOut(HttpSession session){
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }




    /**
     * 退出
     */
    @RequestMapping(value = "logoutsys",method = RequestMethod.GET)
    public String logOutSys(HttpSession session){
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "../../index";
    }

}
