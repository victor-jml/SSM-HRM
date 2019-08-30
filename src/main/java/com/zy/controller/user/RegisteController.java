package com.zy.controller.user;




import com.zy.bean.User;
import com.zy.service.UserService;
import com.zy.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @project : HRM
 * @description : 控制器-管理注册页面
 * @author : zy
 */

@Controller
@RequestMapping("registe")
public class RegisteController {
    @Autowired
    UserService userService;

    /**
     *
     * 功能描述: 跳转注册账号页面
     *
     * @param: null
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:28
     */
    @RequestMapping("toRegiste.html")
    public String toRegiste(){return "user/registe";}

    /**
     *
     * 功能描述: 注册用户
     *
     * @param: user
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:28
     */
    @RequestMapping("userRegiste.html")
    @ResponseBody
    public Map<String,Object> userRegiste(User user){
        Map<String,Object> map = new HashMap<>();
       map.put("data",userService.userRegiste(user));
       return map;
    }

}
