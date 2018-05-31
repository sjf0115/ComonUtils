package com.sjf.util.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * Created by xiaosi on 17-1-11.
 *
 * 读取配置文件
 *
 */
public class PropertyUtil {

    private static Properties props;
    private static Map<String, String> propsMap = Maps.newHashMap();

    /**
     * 初始化
     * @param path
     */
    public static void init(String path) throws IOException {
        if(StringUtils.isBlank(path)){
            return;
        }
        props = new Properties();
        props.load(PropertyUtil.class.getClassLoader().getResourceAsStream(path));
        Set keys = props.keySet();
        for (Iterator iterator = keys.iterator(); iterator.hasNext();){
            String key = iterator.next().toString();
            propsMap.put(key, props.getProperty(key));
        }
    }

    /**
     * 读取单个配置项
     * @param key
     * @return
     */
    public static String getFilterProperty(String key){

        if(StringUtils.isBlank(key)){
            return null;
        }
        return propsMap.get(key);

    }

    /**
     * 读取所有配置文件
     * @return
     */
    public static Map<String, String> getAllFilterProps(){

        return propsMap;

    }

}
