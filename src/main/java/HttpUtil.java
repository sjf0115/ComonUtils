import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Http工具类
 * @author sjf0115
 * @Date Created in 下午2:09 18-1-23
 */
public class HttpUtil {

    /**
     * 配置超时时间
     */
    private static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(5000).setConnectionRequestTimeout(5000)
            .setSocketTimeout(5000).setRedirectsEnabled(true).build();
    private static CloseableHttpClient httpClient = HttpClients.custom().build();

    /**
     * Get 请求
     * @param url
     * @param paramMap
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String httpGet(String url, Map<String, String> paramMap) throws URISyntaxException, IOException {

        checkNotNull(url);
        checkNotNull(paramMap);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        URIBuilder uriBuilder = new URIBuilder(url);
        if(!paramMap.isEmpty()) {
            List<NameValuePair> paramsList = paramsConverter(paramMap);
            uriBuilder.setParameters(paramsList);
        }
        httpGet.setURI(uriBuilder.build());
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return toString(httpResponse);

    }

    /**
     * Post请求
     * @param url
     * @param paramMap
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String httpPost(String url, Map<String, String> paramMap) throws URISyntaxException, IOException {

        checkNotNull(url);
        checkNotNull(paramMap);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        URIBuilder uriBuilder = new URIBuilder(url);
        if(!paramMap.isEmpty()) {
            List<NameValuePair> paramsList = paramsConverter(paramMap);
            uriBuilder.setParameters(paramsList);
        }
        httpPost.setURI(uriBuilder.build());
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        return toString(httpResponse);

    }

    /**
     * 参数转换
     * @param paramMap
     * @return
     */
    private static List<NameValuePair> paramsConverter(Map<String, String> paramMap){

        checkNotNull(paramMap);
        List<NameValuePair> paramsList = Lists.newArrayList();
        Set<Map.Entry<String, String>> entries = paramMap.entrySet();
        for (Map.Entry<String, String> paramEntry : entries) {
            paramsList.add(new BasicNameValuePair(paramEntry.getKey(), paramEntry.getValue()));
        }
        return paramsList;

    }

    /**
     * 转换为String
     * @param httpResponse
     * @return
     * @throws IOException
     */
    private static String toString(CloseableHttpResponse httpResponse) throws IOException {

        checkNotNull(httpResponse);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        int errorCode = 200;
        if (statusCode != errorCode) {
            throw new RuntimeException("http 请求失败");
        }
        String json = EntityUtils.toString(httpResponse.getEntity());
        return json;

    }

}
