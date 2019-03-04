package com.specular.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/01 11:53
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RegisterForm {
    /**
     * 用户名
     */
    String username;
    /**
     * 用户密码
     */
    String password;
    /**
     * 用户邮箱
     */
    String email;
    /**
     * 手机号
     */
    String phone;
}
