package com.specular.api;

import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.form.LoginForm;
import com.specular.service.AuthService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("api/test")
@Slf4j
public class TestController extends PublicController {
    
    @Autowired
    AuthService authService;
    
    /**
     * 登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/test1")
    public ResponseDto login() throws Exception{
        log.info("异常");
        throw new  Exception("异常");
        //return success(authService.login());
    }
    
    
}
