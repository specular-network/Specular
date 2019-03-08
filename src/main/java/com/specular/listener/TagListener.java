package com.specular.listener;

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
    void onPrePersist() {}
    @PostPersist void onPostPersist() {}
    @PostLoad
    void onPostLoad() {}
    @PreUpdate
    void onPreUpdate() {}
    @PostUpdate
    void onPostUpdate() {}
    @PreRemove void onPreRemove() {}
    @PostRemove void onPostRemove() {}
}
