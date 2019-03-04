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
    
    private String email;
    
    private String phone;
    
    /**
     * 账户禁用状态 0 为正常状态
     */
    private Integer ban;
    
    @JsonProperty("token")
    private String tokenCode;
}
