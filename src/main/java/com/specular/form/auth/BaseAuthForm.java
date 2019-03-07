package com.specular.form.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/07 16:07
 * @Description:
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseAuthForm {
    String token;
}
