package com.specular.entity;

import com.specular.listener.BiuListener;
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
@SQLDelete(sql = "update biu set deleted_at = UNIX_TIMESTAMP() where id = ?")
@Where(clause = "deleted_at = 0")
@EntityListeners(BiuListener.class)
@Builder
public class Biu {
    
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * biu 内容
     */
    private String content;
    
    /**
     * biu缓存的tag
     */
    private String tags;
    
    /**
     * 提醒某人
     */
    private String atUser;
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
