package com.specular.repository;

import com.specular.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author jzx
 * @date 2019/02/28 15:29
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * 根据用户名找到用户
     * @param username
     * @return
     */
    Optional<User> findFirstByUsername(String username);
    /**
     * 根据邮箱找到用户
     * @param email
     * @return
     */
    Optional<User> findFirstByEmail(String email);
    
    /**
     * 如果token获取用户信息
     */
    Optional<User> findFirstByTokenCode(String token);
}
