package com.specular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
