package com.specular.service;

import com.specular.dto.UserDto;
import com.specular.entity.User;
import com.specular.form.LoginForm;
import com.specular.form.LogoutForm;
import com.specular.form.RegisterForm;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

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
    
    Boolean logout(LogoutForm logoutForm);
    
    UserDto register(RegisterForm registerForm);
}
