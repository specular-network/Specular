package com.specular.entity;

import com.specular.listener.UserListener;
import lombok.Builder;
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
@EntityListeners(UserListener.class)
@Builder
public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    private String phone;
    
    /**
     * 账户禁用状态 0 为正常状态
     */
    private Integer ban;
    /**
     * 用户登录token
     */
    private String tokenCode;
    /**
     * 用户缓存的tag
     */
    private String tags;
    
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
