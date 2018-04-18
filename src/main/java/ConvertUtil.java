import com.google.common.base.Objects;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 转换工具类
 * @author sjf0115
 * @Date Created in 上午10:24 18-1-24
 */
public class ConvertUtil {

    /**
     * MD5加密
     * @param source
     * @return
     */
    public static String md5(String source) {

        if(StringUtils.isBlank(source)) {
            return source;
        }
        return DigestUtils.md5Hex(source);

    }

    /**
     * 转换为Double
     * @param str
     * @return
     */
    public static double toDouble(String str){

        checkNotNull(str);
        if(StringUtils.isBlank(str)){
            return 0.0;
        }
        try{
            return Double.parseDouble(str);
        }
        catch (Exception e){
            return 0.0;
        }
    }

    /**
     * 转换为Int
     * @param str
     * @return
     */
    public static int toInt(String str){

        checkNotNull(str);
        try{
            return Integer.parseInt(str);
        }
        catch (Exception e){
            return 0;
        }
    }

    /**
     * 根据key获取value
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getOrDefault(Map<String, String> map, String key, String defaultValue){

        checkNotNull(map);
        if(StringUtils.isBlank(key) || Objects.equal(map, null) || map.size() == 0){
            return defaultValue;
        }

        if(map.containsKey(key)){
            return map.get(key);
        }
        return defaultValue;

    }


}
