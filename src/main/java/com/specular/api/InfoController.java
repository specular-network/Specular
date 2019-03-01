package com.specular.api;

import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.config.ApiConfig;
import com.specular.config.AppConfig;
import com.specular.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 * @Description:
 */
@RestController
@RequestMapping("api/info")
@Slf4j
public class InfoController extends PublicController {

}
