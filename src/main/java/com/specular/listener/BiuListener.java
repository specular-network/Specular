package com.specular.listener;

import com.specular.entity.Biu;
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
public class BiuListener {
    
    @PrePersist
    void onPrePersist(Biu biu) {
    }
    
    @PostPersist
    void onPostPersist(Biu biu) {
    }
    
    @PostLoad
    void onPostLoad(Biu biu) {
    }
    
    @PreUpdate
    void onPreUpdate(Biu biu) {
    }
    
    @PostUpdate
    void onPostUpdate(Biu biu) {
    }
    
    @PreRemove
    void onPreRemove(Biu biu) {
    }
    
    @PostRemove
    void onPostRemove(Biu biu) {
    }
}
