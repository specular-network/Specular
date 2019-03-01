package com.specular.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jzx
 * @date 2019/03/01 11:53
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterForm {
    String username;
    String email;
}
