package com.specular.repository;

import com.specular.entity.Biu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author jzx
 * @date 2019/02/28 15:29
 * @Description:
 */
@Repository
public interface BiuRepository extends JpaRepository<Biu, Long>, JpaSpecificationExecutor<Biu> {
}
