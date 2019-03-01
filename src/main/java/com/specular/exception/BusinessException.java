package com.specular.exception;

import com.specular.enums.IExceptionEnum;
import lombok.Getter;

import java.util.HashMap;


/**
 * @author jzx
 * @Package com.specular.product.exception
 * @Description:
 * @date 2018/7/19上午1:26
 */
public class BusinessException extends RuntimeException {

    @Getter
    private Integer code;

    @Getter
    private Object data = new HashMap<>();
    
    public BusinessException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(IExceptionEnum exceptionEnum, Object data) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.data = data;
    }

    public BusinessException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}
