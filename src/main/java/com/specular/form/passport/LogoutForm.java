package com.specular.form.passport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/01 11:35
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogoutForm {
    String token;
}
