package com.zy.service;

import com.zy.bean.User;
import com.zy.util.EmailVerifyCode;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     *
     * 功能描述: 检查用户是否存在
     *
     * @param: user
     * @return: User
     * @auther: zy
     * @date: 2019/8/28 15:30
     */
    User loginCheck(User user);

    /**
     *
     * 功能描述: 更新用户session
     *
     * @param: id
     * @return: HttpSession
     * @auther: zy
     * @date: 2019/8/28 15:31
     */
    
    void updateUserSession(String id,HttpSession session);

    /**
     *
     * 功能描述: 用户注册服务
     *
     * @param: user
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:31
     */
    String userRegiste(User user);

    /**
     *
     * 功能描述: 检查邮箱是否存在
     *
     * @param: email
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:06
     */
    String emailCheck(String email);

    /**
     *
     * 功能描述: 上传头像服务
     *
     * @param: MultipartFile,HttpServletRequest,userId
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:06
     */
    String uploadUserIcon(MultipartFile file, HttpServletRequest request, String userId);

    /**
     *
     * 功能描述: 通过邮箱获取用户
     *
     * @param: email
     * @return: User
     * @auther: zy
     * @date: 2019/8/28 16:07
     */
    User getUserByEmail(String email);

    /**
     *
     * 功能描述: 获取邮箱验证码服务
     *
     * @param: email
     * @return: EmailVerifyCode
     * @auther: zy
     * @date: 2019/8/28 16:07
     */
    EmailVerifyCode sendCodeToEmail(String email);

    /**
     *
     * 功能描述: 验证邮箱验证码是否正确
     *
     * @param: code,session
     * @return: boolean
     * @auther: zy
     * @date: 2019/8/28 16:08
     */
    boolean testEmailCode(String code, HttpSession session);

    /**
     *
     * 功能描述: 设置用户基本信息服务
     *
     * @param: user,HttpSession
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:08
     */
    String setUserInfo(User user,HttpSession session);

    /**
     *
     * 功能描述: 根据邮箱重置密码(忘记密码)
     *
     * @param: user
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:08
     */
    String resetPwdByEmail(User user);

    /**
     *
     * 功能描述: 根据旧密码重置密码服务
     *
     * @param:  user,oldPassword,newPassword
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:09
     */
    String resetPwdByOld(User user,String oldPassword,String newPassword);

    /**
     *
     * 功能描述: 重置邮箱服务
     *
     * @param: user,oldEmail,newEmail
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 16:10
     */
    String resetEmail(User user,String oldEmail,String newEmail);

    /**
     *
     * 功能描述: 通过id获取邮箱
     *
     * @param: id
     * @return: User
     * @auther: zy
     * @date: 2019/8/28 16:10
     */
    User getUser(String id);

    /**
     *
     * 功能描述: 更新用户信息
     *
     * @param: user
     * @return: int
     * @auther: zy
     * @date: 2019/8/28 16:10
     */
    int updateUser(User user);

    /**
     *
     * 功能描述: 判断当前用户是否为管理员
     *
     * @param: HttpSession
     * @return: boolean
     * @auther: zy
     * @date: 2019/8/28 17:16
     */
    boolean ifUserIsAdmin(HttpSession session);
}
