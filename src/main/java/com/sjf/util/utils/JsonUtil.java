package com.sjf.util.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author sjf0115
 * @Date Created in 下午4:43 18-4-18
 */
public class JsonUtil {

    /**
     * 获取field字段指定的值
     * @param jsonObject
     * @param field
     * @return
     */
    public static String getAsString(JsonObject jsonObject, String field){

        String result = null;
        if(jsonObject == null || StringUtils.isBlank(field)){
            return result;
        }
        if(!jsonObject.has(field)) {
            return result;
        }
        JsonElement element = jsonObject.get(field);
        if(!element.isJsonPrimitive()){
            return result;
        }
        result = element.getAsString();
        return result;

    }

    /**
     * 获取field字段指定的值
     * @param jsonObject
     * @param field
     * @return
     */
    public static Double getAsDouble(JsonObject jsonObject, String field){

        Double result = null;
        if(jsonObject == null || StringUtils.isBlank(field)){
            return result;
        }
        if(!jsonObject.has(field)) {
            return result;
        }
        JsonElement element = jsonObject.get(field);
        if(!element.isJsonPrimitive()){
            return result;
        }
        result = element.getAsDouble();
        return result;

    }

}
