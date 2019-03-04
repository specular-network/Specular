package com.specular.service.impl;

import com.google.common.net.HttpHeaders;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

/**
 * @author jzx
 * @date 2019/03/01 11:33
 * @Description:
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    HttpServletRequest httpServletRequest;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    DigestService digestService;
    
    @Override
    public UserDto login(LoginForm loginForm) {
        UserDto userDto = new UserDto();
        Optional<User> user = userRepository.findFirstByUsername(loginForm.getUsername());
        user.orElseThrow(() -> new BusinessException(BusinessExceptionEnum.USER_NOT_FOUND_ERROR));
        user.ifPresent(user1 -> {
            if(!user1.getBan().equals(0)){
                throw new BusinessException(BusinessExceptionEnum.USER_IS_BAN);
            }
            if (digestService.encrypt(loginForm.getPassword()).equals(user1.getPassword())) {
                user1.setTokenCode(UUID.randomUUID().toString());
                user1.setLastLoginIp(httpServletRequest.getRemoteAddr());
                String userAgent = httpServletRequest.getHeader(HttpHeaders.USER_AGENT);
                if (userAgent.isEmpty()) {
                    log.info("User-Agent is Empty");
                    user1.setLastLoginUa("");
                } else {
                    user1.setLastLoginUa(httpServletRequest.getHeader(HttpHeaders.USER_AGENT));
                }
                userRepository.save(user1);
                BeanUtils.copyProperties(user1, userDto);
            } else {
                throw new BusinessException(BusinessExceptionEnum.LOGIN_ERROR);
            }
        });
        return userDto;
    }
    
    @Override
    public Boolean logout(LogoutForm logoutForm) {
        return null;
    }
    
    
    /**
     * TODO 用户名邮箱格式验证
     *
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
        UserDto userDto = new UserDto();
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        user.setPassword(digestService.encrypt(registerForm.getPassword()));
        user.setTokenCode(UUID.randomUUID().toString());
        user.setCreatedAt(DateUtils.getTimeSpan());
        user.setUpdatedAt(DateUtils.getTimeSpan());
        user.setDeletedAt(0);
        user.setMailboxValidation(0);
        user.setSmsValidation(0);
        user.setPhone(registerForm.getPhone());
        user.setLastLoginIp(httpServletRequest.getRemoteAddr());
        String userAgent = httpServletRequest.getHeader(HttpHeaders.USER_AGENT);
        if (userAgent.isEmpty()) {
            log.info("User-Agent is Empty");
            user.setLastLoginUa("");
        } else {
            user.setLastLoginUa(httpServletRequest.getHeader(HttpHeaders.USER_AGENT));
        }
        user = userRepository.save(user);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
    
    /**
     * TODO
     * @param phone
     */
    @Override
    @Async
    public void sendMailVerif(String phone) {
        log.info(">>> send mail verif");
    }
    
    /**
     * TODO
     * @param phone
     */
    @Override
    @Async
    public void sendSmsVerif(String email) {
        log.info(">>> send sms verif");
    }
}
