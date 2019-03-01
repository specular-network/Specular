package com.specular.api;

import com.specular.annotation.Auth;
import com.specular.base.controller.BaseController;
import com.specular.base.dto.ResponseDto;
import com.specular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 * @Description:
 */
@RestController
@RequestMapping("api/user")
@Auth
public class UserController extends BaseController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/list")
    @Auth
    public ResponseDto list() throws Exception {
        return success(userService.getUserDtoList());
    }
}
