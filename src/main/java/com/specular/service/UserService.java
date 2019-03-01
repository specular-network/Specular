package com.specular.service;

import com.specular.dto.UserDto;
import com.specular.entity.User;

import java.util.List;

/**
 * @author jzx
 * @date 2019/02/28 15:33
 * @Description:
 */
public interface UserService {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
    
    /**
     * 获取用户列表
     * @return
     */
    List<UserDto> getUserDtoList();
}
