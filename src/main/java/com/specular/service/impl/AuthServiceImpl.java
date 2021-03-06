package com.specular.service.impl;

import com.google.common.net.HttpHeaders;
import com.specular.dto.UserDto;
import com.specular.entity.User;
import com.specular.enums.BusinessExceptionEnum;
import com.specular.exception.BusinessException;
import com.specular.form.passport.LoginForm;
import com.specular.form.passport.LogoutForm;
import com.specular.form.passport.RegisterForm;
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

import static com.specular.constant.BaseConstant.*;

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
    
        User user = User.builder()
                            .email(registerForm.getEmail())
                            .username(registerForm.getUsername())
                            .password(digestService.encrypt(registerForm.getPassword()))
                            .tokenCode(UUID.randomUUID().toString())
                            .tags(DEFAULT_TAGS)
                            .phone(registerForm.getPhone())
                            .lastLoginIp(httpServletRequest.getRemoteAddr())
                            .lastLoginUa(httpServletRequest.getHeader(HttpHeaders.USER_AGENT))
                            .mailboxValidation(DEFAULT_EMAILVALIDATION)
                            .smsValidation(DEFAULT_SMSVALIDATION)
                            .deletedAt(DEFAULT_DELETED_AT)
                            .createdAt(DateUtils.getTimeSpan())
                            .updatedAt(DateUtils.getTimeSpan())
                            .build();
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
     * @param email
     */
    @Override
    @Async
    public void sendSmsVerif(String email) {
        log.info(">>> send sms verif");
    }
    
    @Override
    public UserDto getUserInfoByToken(String token) {
        UserDto userDto=new UserDto();
        User user=userRepository.findFirstByTokenCode(token).orElseThrow(()->new BusinessException(BusinessExceptionEnum.TOKEN_NOT_FOUND_ERROR));
        BeanUtils.copyProperties(user,userDto);
        return  userDto;
    }
}
