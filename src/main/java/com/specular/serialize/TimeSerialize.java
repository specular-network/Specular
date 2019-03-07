package com.specular.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.specular.util.DateUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


/**
 * @author jzx
 * @date 2019/03/04 10:24
 * @Description:
 */

@Slf4j
public class TimeSerialize extends JsonSerializer<Integer> {
    @Override
    public void serialize(Integer s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            if(s.equals(0)){
                jsonGenerator.writeObject("");
            }else {
                jsonGenerator.writeObject(DateUtils.timeTostr(s, "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (Exception ex) {
            try {
                jsonGenerator.writeObject("");
            } catch (IOException e) {
                log.warn("", e);
            }
        }
    }
}
