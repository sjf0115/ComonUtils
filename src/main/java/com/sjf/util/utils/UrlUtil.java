package com.sjf.util.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * URL工具类
 * Created by xiaosi on 17-8-9.
 */
public class UrlUtil {

    private static Logger logger = LoggerFactory.getLogger(UrlUtil.class);
    private static Pattern urlPattern = Pattern.compile("^((https|http|ftp|rtsp|mms)?:\\/\\/).*?");

    /**
     * 正则替换 "key":"value"格式
     * @param url
     * @param key
     * @param value
     * @return
     */
    public static String replaceUrlColonParamByReg(String url, String key, String value) {

        if(StringUtils.isBlank(url) || StringUtils.isBlank(key)){
            return url;
        }

        url = url.replaceAll("(\"" + key + "\":\"[^\"]*\")", "\"" + key + "\":\"" + value +"\"");
        return url;

    }

    /**
     * 正则替换 key=value格式
     * @param url
     * @param key
     * @param value
     * @return
     */
    public static String replaceUrlEqualParamByReg(String url, String key, String value) {

        if(StringUtils.isBlank(url) || StringUtils.isBlank(key)){
            return url;
        }
        url = url.replaceAll("(" + key + "=[^&]*)", key + "=" + value);
        return url;

    }

    /**
     * 正则替换 key=value格式 "key":"value"格式
     * @param url
     * @param key
     * @param value
     * @return
     */
    public static String replaceUrlParamByReg(String url, String key, String value) {

        if(StringUtils.isBlank(url) || StringUtils.isBlank(key)){
            return url;
        }

        if(find(url, key + "=[^&]*")){
            url = replaceUrlEqualParamByReg(url, key, value);
        }
        else if(find(url, "\"" + key + "\":\"[^\"]*\"")){
            url = replaceUrlColonParamByReg(url, key, value);
        }

        return url;

    }

    /**
     * 根据正则表达式判断是否在字符串中
     * @param str
     * @param regex
     * @return
     */
    private static boolean find(String str, String regex){

        if(StringUtils.isBlank(str) || StringUtils.isBlank(regex)){
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();

    }

    /**
     * 判断是否是有效的URL
     * @param url
     * @return
     */
    public static boolean isValid(String url){

        if(StringUtils.isBlank(url)){
            return false;
        }
        Matcher matcher = urlPattern.matcher(url);
        return matcher.matches();

    }

    /**
     * URL编码
     * @param url
     * @return
     */
    public static String encode(String url){

        if(StringUtils.isBlank(url)){
            return url;
        }

        try {
            String encodeUrl = URLEncoder.encode(url, "UTF-8");
            return encodeUrl;
        } catch (UnsupportedEncodingException e) {
            logger.error("URL编码失败", e);
            return url;
        }

    }

    /**
     * URL解码
     * @param url
     * @return
     */
    public static String decode(String url){

        if(StringUtils.isBlank(url)){
            return url;
        }

        try {
            String decodeUrl = URLDecoder.decode(url, "UTF-8");
            return decodeUrl;
        } catch (UnsupportedEncodingException e) {
            logger.error("URL解码失败", e);
            return url;
        }

    }

}
