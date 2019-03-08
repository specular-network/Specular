package com.specular.entity;

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
@SQLDelete(sql = "update tag_biu set deleted_at = UNIX_TIMESTAMP() where id = ?")
@Where(clause = "deleted_at = 0")
public class TagBiu {
    
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * tag id
     */
    private Long tagId;
    
    /**
     * biu id
     */
    private Long biuId;
    
    
    /**
     * 创建用户
     */
    private Long createdUserId;
    /**
     * 更新用户
     */
    private Long updatedUserId;
    /**
     *
     */
    private Integer createdAt;
    private Integer updatedAt;
    private Integer deletedAt;
    
}
