package com.specular.repository;

import com.specular.entity.TagBiu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author jzx
 * @date 2019/02/28 15:29
 * @Description:
 */
@Repository
public interface TagBiuRepository extends JpaRepository<TagBiu, Long>, JpaSpecificationExecutor<TagBiu> {
}
