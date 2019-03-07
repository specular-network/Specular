package com.specular.form.passport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jzx
 * @date 2019/03/01 11:54
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryForm {
    String token;
}
