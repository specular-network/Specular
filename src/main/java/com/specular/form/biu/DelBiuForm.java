package com.specular.form.biu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.specular.form.auth.BaseAuthForm;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/01 11:35
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DelBiuForm extends BaseAuthForm {
    Long id;
}
