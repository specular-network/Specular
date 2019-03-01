package com.specular.dto;

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

@Entity
@Data
@SQLDelete(sql = "update user set deleted_at = UNIX_TIMESTAMP() where id = ?")
@Where(clause = "deleted_at = 0")
public class UserDto {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
}
