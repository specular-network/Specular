package com.specular.form.tag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/01 11:35
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagForm {
    String name;
    Long id;
}
