package com.specular.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jzx
 * @date 2019/03/04 10:24
 * @Description:
 */
@Slf4j
public class DateUtils {
    public static Integer getTimeSpan(){
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime() / 1000L);
        return Integer.valueOf(timestamp);
    }
    
    /**
     * 格式化指定格式
     * @param ms
     * @return
     */
    public static String timeTostr(Integer ms,String pattern) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                str = sdf.format(msl);
            } catch (Exception e) {
                log.warn("",e.getMessage());
            }
        }
        return str;
        
    }
}
