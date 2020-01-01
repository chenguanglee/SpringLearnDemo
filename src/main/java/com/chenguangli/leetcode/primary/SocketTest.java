package com.chenguangli.leetcode.primary;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * @author chenguangli
 * @date 2019/11/3 11:55
 */
public class SocketTest {

    @Test
    public void test1() throws Exception{

        HttpGet httpGet = new HttpGet("http://www.zhihu.com");
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
        response.close();
        closeableHttpClient.close();
    }
}
