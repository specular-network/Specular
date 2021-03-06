package com.specular.enums;

import lombok.Getter;

/**
 * @author jzx
 */
@Getter
public enum BusinessExceptionEnum implements IExceptionEnum {

    /*未知异常*/
    LOGIN_ERROR(10000,"用户名密码错误"),
    USER_NOT_FOUND_ERROR(10001,"用户名密码错误"),
    USER_NAME_ALREADY_EXISTS(10002,"用户名已经存在"),
    MAILBOX_IS_ALREADY_OCCUPIED(10003,"邮箱已经被占用"),
    USER_IS_BAN(10004,"账户已经被禁用"),
    TOKEN_NOT_FOUND_ERROR(10005,"token错误"),
    
    BIU_NOT_FOUND_ERROR(11000,"biu不存在"),
    
    
    SYSTEM_ERROR(-1,"未知异常");


    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
