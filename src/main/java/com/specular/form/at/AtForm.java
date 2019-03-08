package com.specular.form.at;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/03/01 11:35
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtForm {
    /**
     * 用户姓名
     */
    String name;
    /**
     * 用户id
     */
    Long id;
}
