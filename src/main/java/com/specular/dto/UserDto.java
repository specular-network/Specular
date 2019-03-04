package com.specular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jzx
 * @date 2019/02/28 15:29
 * @Description:
 */


@Data
public class UserDto {

    
    private Long id;
    
    private String username;
    
    @JsonProperty("token")
    private String tokenCode;
}
