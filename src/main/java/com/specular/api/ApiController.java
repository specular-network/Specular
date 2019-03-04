package com.specular.api;

import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.config.ApiConfig;
import com.specular.dto.ApiConfigDto;
import com.specular.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 * @Description:
 */
@RestController
@RequestMapping("api")
@Slf4j
public class ApiController extends PublicController {
    
    
    @Autowired
    ApiConfig apiConfig;
    
    @RequestMapping("/info")
    public ResponseDto api() throws Exception{
        ApiConfigDto apiConfigDto=new ApiConfigDto();
        BeanUtils.copyProperties(apiConfig,apiConfigDto);
        return success(apiConfigDto);
    }
    
    
}
