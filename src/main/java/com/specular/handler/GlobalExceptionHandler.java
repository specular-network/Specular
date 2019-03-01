package com.specular.handler;

import com.specular.base.dto.ResponseDto;
import com.specular.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author jzx
 * @Package com.specular.handler
 * @Description:
 * @date 2018/7/19上午1:23
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseDto handlerBusinessException(BusinessException ex){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(ex.getCode());
        responseDto.setMsg(ex.getMessage());
        responseDto.setData(ex.getData());
        return  responseDto;
    }
    
    
    
    @ExceptionHandler(value = java.lang.Exception.class)
    public ResponseDto exceptionGet(Exception e){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(-1);
        responseDto.setMsg(e.getMessage());
        responseDto.setData(null);
        return  responseDto;
    }



    public static String getExceptionAllInfo(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try(PrintStream pout = new PrintStream(out)
          ){
            ex.printStackTrace(pout);
           return  String.valueOf(out.toByteArray());
        }catch (Exception e){
            return ex.getMessage();
        }
    }
}
