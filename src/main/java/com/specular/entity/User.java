package com.specular.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author jzx
 * @date 2019/02/28 15:29
 * @Description:
 */

@Entity
@Data
@SQLDelete(sql = "update user set deleted_at = UNIX_TIMESTAMP() where id = ?")
@Where(clause = "deleted_at = 0")
public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;
    private String email;
    
    private String tokenCode;
    
    /**
     * 邮箱验证
     */
    private Integer mailboxValidation;
    /**
     * 短信验证
     */
    private Integer smsValidation;
    /**
     * 最后登录ip
     */
    private String lastLoginIp;
    /**
     * 最后登录ip
     */
    private String lastLoginUa;
    
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
}
