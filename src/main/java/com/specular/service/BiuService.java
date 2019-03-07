package com.specular.service;

import com.specular.form.biu.DelBiuForm;
import com.specular.form.biu.MakeBiuForm;

/**
 * @author jzx
 * @date 2019/02/28 15:33
 * @Description:
 */
public interface BiuService {
    void make(MakeBiuForm makeBiuForm);
    
    void del(DelBiuForm delBiuForm);
}
