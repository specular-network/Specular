package com.specular.api;

import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.form.LoginForm;
import com.specular.form.LogoutForm;
import com.specular.form.RegisterForm;
import com.specular.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 */
@RestController
@RequestMapping("api/passport")
public class PassportController extends PublicController {
    
    @Autowired
    AuthService authService;
    
    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public ResponseDto login(@RequestBody LoginForm loginForm) {
        return success(authService.login(loginForm));
    }
    
    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("/logout")
    public ResponseDto logout(@RequestBody LogoutForm logoutForm) {
        return success(authService.logout(logoutForm));
    }
    
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public ResponseDto register(@RequestBody RegisterForm registerForm) {
        return success(authService.register(registerForm));
    }
}
