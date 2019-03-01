package com.specular.api;

import com.specular.base.controller.BaseController;
import com.specular.base.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/02/25 10:46
 * @Description:
 */
@RestController
@RequestMapping("api/update")
public class UpdateController extends BaseController {
    
    @RequestMapping("/check")
    public ResponseDto check() throws Exception {
        return success();
    }
}
