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
    String username;
    String password;
    String email;
}
