package com.specular.service;

import com.specular.dto.UserDto;
import com.specular.form.LoginForm;
import com.specular.form.LogoutForm;
import com.specular.form.RegisterForm;

/**
 * @author jzx
 * @date 2019/02/28 15:33
 * @Description:
 */
public interface AuthService {
    /**
     * 登录
     * @return
     */
    UserDto login(LoginForm loginForm);
    
    /**
     * 退出登录
     * @param logoutForm
     * @return
     */
    Boolean logout(LogoutForm logoutForm);
    
    /**
     * 注册
     * @param registerForm
     * @return
     */
    UserDto register(RegisterForm registerForm);
    
    /**
     * 邮箱验证
     * @param phone
     */
    void sendMailVerif(String phone);
    
    /**
     * 短信验证
     * @param email
     */
    void sendSmsVerif(String email);
}
