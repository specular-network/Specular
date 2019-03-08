package com.specular.form.biu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.specular.form.at.AtForm;
import com.specular.form.auth.BaseAuthForm;
import com.specular.form.tag.TagForm;
import lombok.Data;

import java.util.List;

/**
 * @author jzx
 * @date 2019/03/01 11:35
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MakeBiuForm extends BaseAuthForm {
    String content;
    List<TagForm> tags;
    List<AtForm> at;
}
