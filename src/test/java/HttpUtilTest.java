import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author sjf0115
 * @Date Created in 下午2:28 18-1-23
 */
public class HttpUtilTest {
    @Test
    public void httpGet() throws Exception {

        String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php";
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("query", "0.148.7.0");
        paramsMap.put("resource_id","6006");
        paramsMap.put("t","1516689086692");
        paramsMap.put("ie","utf8");
        paramsMap.put("oe","gbk");
        paramsMap.put("cb","op_aladdin_callback");
        paramsMap.put("format","json");
        paramsMap.put("tn", "baidu");
        paramsMap.put("cb", "jQuery110205798053672419516_1516689071181&_=1516689071186");

        String json = HttpUtil.httpGet(url, paramsMap);
        System.out.println(json);

    }

    @Test
    public void httpPost() throws Exception {

        String url = "http://ip.taobao.com/service/getIpInfo2.php";
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("ip", "218.59.255.255");
        String json = HttpUtil.httpPost(url, paramsMap);
        System.out.println(json);

    }

}