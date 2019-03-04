package com.specular.util;

import java.util.Date;

/**
 * @author jzx
 * @date 2019/03/04 10:24
 * @Description:
 */
public class DateUtils {
    public static Integer getTimeSpan(){
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime() / 1000L);
        return Integer.valueOf(timestamp);
    }
}
