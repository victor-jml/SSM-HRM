package com.zy.controller.user;


import com.zy.bean.User;
import com.zy.interceptor.Token;
import com.zy.service.UserService;
import com.zy.util.EmailVerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("forget")
public class ForgetController {

    @Autowired
    UserService userService;

    /**
     *
     * 功能描述: 跳转到忘记密码页面
     *
     * @param: null
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:21
     */
    @RequestMapping("toForget.html")
    @Token(save = true)
    public String toForget(){return "user/forget";}

    /**
     *
     * 功能描述: 检验邮箱是否被注册
     *
     * @param: user
     * @return: map
     * @auther: zy
     * @date: 2019/8/8 12:24
     */
    @RequestMapping("emailCheck.html")
    @ResponseBody
    public Map<String,Object> mailCheck(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userService.emailCheck(user.getEmail()));
        return map;
    }

    /**
     *
     * 功能描述: 向邮箱发送验证码
     *
     * @param: user , session
     * @return: map
     * @auther: zy
     * @date: 2019/8/7 18:18
     */
    @RequestMapping("sendVerifyCodeToEmail.html")
    @ResponseBody
    public Map<String,Object> sendCodeToEmail(User user, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        EmailVerifyCode emailVerifyCode = userService.sendCodeToEmail(user.getEmail());
        session.setAttribute("emailVerifyCode",emailVerifyCode);
        map.put("data","sendSuccess");
        return map;
    }
    /**
     *
     * 功能描述: 验证验证码是否正确并修改密码
     *
     * @param: code,user,session
     * @return: map
     * @auther: zy
     * @date: 2019/8/8 12:47
     */
    @RequestMapping("emailCodeTest.html")
    @Token(remove = true)
    @ResponseBody
    public Map<String,Object> emailCodeTest(@RequestParam(value = "code") String code, User user,HttpSession session){
            Map<String,Object> map = new HashMap<>();
            if(!userService.testEmailCode(code,session)){
                 map.put("data","codeWrong");
                 return map;
            }else {
                map.put("data",userService.resetPwdByEmail(user));
                return map;
            }
    }


}
