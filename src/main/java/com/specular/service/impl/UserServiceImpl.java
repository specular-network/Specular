package com.specular.service.impl;

import com.specular.dto.UserDto;
import com.specular.entity.User;
import com.specular.repository.UserRepository;
import com.specular.service.UserService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jzx
 * @date 2019/02/28 15:33
 * @Description:
 */
@Service
@Data
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
    
    @Override
    public List<UserDto> getUserDtoList() {
        return getUserList().stream().map(user -> {
            UserDto userDto= new UserDto();
            BeanUtils.copyProperties(user,userDto);
            return  userDto;
        }).collect(Collectors.toList());
    }
}
