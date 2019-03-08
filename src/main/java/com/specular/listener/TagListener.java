package com.specular.listener;

import com.specular.entity.Tag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author jzx
 * @date 2019/03/04 11:29
 * @Description:
 */
@Data
@Slf4j
public class TagListener {
    
    
    @PrePersist
    void onPrePersist(Tag tag) {
    }
    
    @PostPersist
    void onPostPersist(Tag tag) {
    }
    
    @PostLoad
    void onPostLoad(Tag tag) {
    }
    
    @PreUpdate
    void onPreUpdate(Tag tag) {
    }
    
    @PostUpdate
    void onPostUpdate(Tag tag) {
    }
    
    @PreRemove
    void onPreRemove(Tag tag) {
    }
    
    @PostRemove
    void onPostRemove(Tag tag) {
    }
}
