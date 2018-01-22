import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配工具类
 * @author sjf0115
 * @Date Created in 上午11:41 17-10-25
 */
public class RegexUtil {

    /**
     * 是否匹配正则表达式
     * @param param
     * @param pattern
     * @return
     */
    public static boolean isFind(String param, Pattern pattern) {

        if(StringUtils.isBlank(param)){
            return false;
        }

        Matcher matcher = pattern.matcher(param);
        return matcher.find();

    }

    /**
     * 是否匹配正则表达式
     * @param param
     * @param reg
     * @return
     */
    public static boolean isFind(String param, String reg) {

        if(StringUtils.isBlank(param) || StringUtils.isBlank(reg)){
            return false;
        }

        Pattern pattern = Pattern.compile(reg);
        boolean result = isFind(param, pattern);
        return result;

    }

    /**
     * 获取匹配值
     * @param param
     * @param reg
     * @param group
     * @return
     */
    public static String getGroupValue(String param, String reg, int group) {

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            return matcher.group(group);
        }
        return "";

    }

    /**
     * 获取匹配值
     * @param param
     * @param pattern
     * @param group
     * @return
     */
    public static String getGroupValue(String param, Pattern pattern, int group)  {

        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            return matcher.group(group);
        }
        return "";

    }

}

