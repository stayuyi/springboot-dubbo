package com.yy.provider1.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/** Created by yuyi on 2018/10/19. */
public class Untils {
  private static HttpRequestBase httpRequestBase;

  public static void setRequest(String url, String requestType) throws IOException {

    if ("get".equals(requestType)) {
      httpRequestBase = new HttpGet(url);
    }

    BufferedReader bufferedReaderHeader =
        new BufferedReader(
            new FileReader(new File("D:\\workspace\\springboot-dubbo\\dubbo-provider1\\src\\main\\resources\\header.properties")));
    Properties header = new Properties();
    header.load(bufferedReaderHeader);
    Set<Map.Entry<Object, Object>> entrySetHeader = header.entrySet();

    for (Map.Entry<Object, Object> entry : entrySetHeader) {
      httpRequestBase.addHeader((String) entry.getKey(), (String) entry.getValue());
    }


   /* BufferedReader bufferedReaderBody=new BufferedReader(new FileReader(new File("D:\\IdeaProjects\\studySpringBoot\\header.properties")));
    Properties body=new Properties();
    body.load(bufferedReaderBody);
    Set<Map.Entry<Object, Object>> entrySetBody = body.entrySet();

    List<NameValuePair> params = new ArrayList<NameValuePair>();

    for (Map.Entry<Object, Object> entry : entrySetBody) {
        params.add(new BasicNameValuePair((String)entry.getKey(),(String) entry.getValue()));
    }
    UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(params, "UTF-8");
      HttpPost httpPost=new HttpPost("");
*/

      CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse response = httpClient.execute(httpRequestBase);

      Header[] allHeaders = httpRequestBase.getAllHeaders();
      System.out.println("-----------------request header--------------------");
      for (int i = 0; i < allHeaders.length; i++) {
          System.out.println(allHeaders[i]);
      }

    System.out.println("----------------- response --------------------");
      if (response.getStatusLine().getStatusCode()==200){
          HttpEntity entity = response.getEntity();
          String s = EntityUtils.toString(entity, "UTF-8");
          System.out.println(s);
      }else {
          System.out.println("请求失败:"+response.getStatusLine().getStatusCode());
      }
  }
}
