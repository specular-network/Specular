package com.specular.api;

import com.specular.base.controller.BaseController;
import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.form.LoginForm;
import com.specular.service.AuthService;
import com.specular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 * @Description:
 */
@RestController
@RequestMapping("api/passport")
public class PassportController extends PublicController {
    
    @Autowired
    AuthService authService;
    
    /**
     * 登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public ResponseDto login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm);
        return success(authService.login());
    }
    
    /**
     * 退出
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public ResponseDto logout() throws Exception {
        return success(authService.logout());
    }
    
    /**
     * 注册
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public ResponseDto register() throws Exception {
        return success(authService.register());
    }
}
