package com.specular.util;

import cn.emay.sdk.util.json.gson.Gson;

/**
 * @author jzx
 * @date 2019/03/08 10:12
 * @Description:
 */
public class JsonUtils {
    private static Gson gson = new Gson();
    public static String objToStr(Object obj){
        return gson.toJson(obj);
    }
}
