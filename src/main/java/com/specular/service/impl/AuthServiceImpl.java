package com.specular.service.impl;

import com.specular.dto.UserDto;
import com.specular.entity.User;
import com.specular.enums.BusinessExceptionEnum;
import com.specular.exception.BusinessException;
import com.specular.form.LoginForm;
import com.specular.form.LogoutForm;
import com.specular.form.RegisterForm;
import com.specular.repository.UserRepository;
import com.specular.service.AuthService;
import com.specular.service.DigestService;
import com.specular.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Optional;
import java.util.UUID;

/**
 * @author jzx
 * @date 2019/03/01 11:33
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    DigestService digestService;
    
    @Override
    public UserDto login(LoginForm loginForm) {
        UserDto userDto=new UserDto();
        Optional<User> user=userRepository.findFirstByUsername(loginForm.getUsername());
        user.orElseThrow(()->new BusinessException(BusinessExceptionEnum.USER_NOT_FOUND_ERROR));
        user.ifPresent(user1 -> {
            if(digestService.encrypt(loginForm.getPassword()).equals(user1.getPassword())){
                user1.setTokenCode(UUID.randomUUID().toString());
                userRepository.save(user1);
                BeanUtils.copyProperties(user1,userDto);
            }else {
                throw  new BusinessException(BusinessExceptionEnum.LOGIN_ERROR);
            }
        });
        return  userDto;
    }
    
    @Override
    public Boolean logout(LogoutForm logoutForm) {
        return null;
    }
    
    
    /**
     * TODO 用户名邮箱格式验证
     * @param registerForm
     * @return
     */
    @Override
    public UserDto register(RegisterForm registerForm) {
        userRepository.findFirstByUsername(registerForm.getUsername()).ifPresent(user1 -> {
            throw new BusinessException(BusinessExceptionEnum.USER_NAME_ALREADY_EXISTS);
        });
        userRepository.findFirstByEmail(registerForm.getEmail()).ifPresent(user1 -> {
            throw new BusinessException(BusinessExceptionEnum.MAILBOX_IS_ALREADY_OCCUPIED);
        });
        UserDto userDto=new UserDto();
        User user=new User();
        BeanUtils.copyProperties(registerForm,user);
        user.setPassword(digestService.encrypt(registerForm.getPassword()));
        user.setTokenCode(UUID.randomUUID().toString());
        user.setCreatedAt(DateUtils.getTimeSpan());
        user.setUpdatedAt(DateUtils.getTimeSpan());
        user.setDeletedAt(0);
        user=userRepository.save(user);
        BeanUtils.copyProperties(user,userDto);
        return  userDto;
    }
}
