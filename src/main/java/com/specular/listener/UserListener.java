package com.specular.listener;

import com.specular.entity.User;
import com.specular.service.AuthService;
import com.specular.util.SpringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;

/**
 * @author jzx
 * @date 2019/03/04 11:29
 * @Description:
 */
@Data
@Slf4j
public class UserListener {
    
    
    @Autowired
    AuthService authService;
    
    @PostPersist
    void onPostPersist(User user) {
        this.authService= SpringUtil.getBean(AuthService.class);
        authService.sendMailVerif(user.getPhone());
        authService.sendSmsVerif(user.getEmail());
    }
}
