package com.zy.interceptor;


import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthorityInterceptor
 * @Author zy
 * @Description 用户权限拦截器
 * @Date 2019/8/28 17:18
 * @Version 1.0
 **/
public class AuthorityInterceptor implements HandlerInterceptor {
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AuthorityInterceptor.class);

    @Autowired
    private UserService userService;

    /**
     *
     * 功能描述: 拦截访问修改页面的请求，如果非管理员身份，提示error.jsp
     *
     * @param: HttpServletRequest,HttpServletResponse,Objerct
     * @return: boolean
     * @auther: zy
     * @date: 2019/8/28 17:18
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (userService.ifUserIsAdmin(httpServletRequest.getSession())) {
            logger.info("管理员访问:" + httpServletRequest.getRequestURI());
            return true;
        }
        logger.info("非管理员访问:" + httpServletRequest.getRequestURI() + " 无操作权限");
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/main/toError.html");
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
