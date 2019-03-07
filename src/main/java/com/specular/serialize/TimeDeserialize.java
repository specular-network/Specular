package com.specular.serialize;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * @author jzx
 * @date 2019/03/04 10:24
 * @Description:
 */

@Slf4j
public class TimeDeserialize extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if("".equals(jp.getText())){
                return 0;
            }
            return  Integer.valueOf(String.valueOf(format.parse(jp.getText()).getTime()/1000L));
        }catch (JsonProcessingException e){
            throw e;
        }catch (Exception e){
            log.error("时间解析异常");
        }
        throw new IOException("时间解析异常");
    }
    
}
