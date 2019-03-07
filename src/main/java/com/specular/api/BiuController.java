package com.specular.api;

import com.specular.base.controller.PublicController;
import com.specular.base.dto.ResponseDto;
import com.specular.form.biu.DelBiuForm;
import com.specular.form.biu.MakeBiuForm;
import com.specular.service.BiuService;
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
@RequestMapping("api/biu")
@Slf4j
public class BiuController extends PublicController {
    
    
    @Autowired
    BiuService biuService;
    /**
     * make biu
     *
     * @return
     */
    @RequestMapping("/make")
    public ResponseDto makeBiu(@RequestBody MakeBiuForm makeBiuForm) {
        biuService.make(makeBiuForm);
        return success();
    }
    
    /**
     * make biu
     *
     * @return
     */
    @RequestMapping("/del")
    public ResponseDto delBiu(@RequestBody DelBiuForm DelBiuForm) {
        biuService.del(DelBiuForm);
        return success();
    }
    
}
