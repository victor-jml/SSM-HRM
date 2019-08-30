package com.zy.controller.user;


import com.sun.deploy.net.HttpResponse;
import com.zy.bean.User;
import com.zy.service.UserService;
import com.zy.util.JsonMsg;
import com.zy.util.setCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @project : HRM
 * @description : 控制器-管理登录页面
 * @author : zy
 */

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;

    /**
     *
     * 功能描述: 跳转到登录页面
     *
     * @param: null
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:22
     */
    @RequestMapping("toLogin.html")
    public String toLogin(){return "user/login";}
    
    /**
     *
     * 功能描述: 登录验证
     *
     * @param: user,remember,HttpSession,HttpServletRequest,HttpServletResponse
     * @return: JsonMsg
     * @auther: zy
     * @date: 2019/8/28 15:23
     */
    @RequestMapping("loginCheck.html")
    @ResponseBody
    public JsonMsg loginCheck(User user,@RequestParam(value = "remember",required = false)String remember, HttpSession session
    ,HttpServletRequest request,HttpServletResponse response){
            User userSessionInfo = userService.loginCheck(user);  //验证用户名是否存在
            if(userSessionInfo != null){
                session.setAttribute("user",userSessionInfo);
                System.out.println(remember);
                setCookie.setUserLoginCookie(user.getName(),user.getPassword(),remember,request,response);
                return JsonMsg.success();
            }else {
                return JsonMsg.fail().addInfo("login_error","输入的账号或者密码错误,请重新输入!");
            }
    }

    /**
     *
     * 功能描述: 跳转到主页
     *
     * @param: null
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:24
     */
    @RequestMapping("toMain.html")
    public String toMain(){return "index";}

    /**
     *
     * 功能描述: 账号登出
     *
     * @param: HttpSession,HttpServletResponse
     * @return: void
     * @auther: zy
     * @date: 2019/8/28 15:25
     */
    @RequestMapping("loginOut.html")
    public void loginOut(HttpSession session, HttpServletResponse response){
        session.removeAttribute("user");

        //注销后重定向到登录页面
        try {
            response.sendRedirect("/login/toLogin.html");
        } catch (IOException e) {
            System.out.println("跳转错误");
        }
    }
}
