package com.ericdoug.webSpider;

/**
 * @Author: EricDoug on 14-11-23.
 * @E-mail: liuxd6688@126.com
 */


import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;



import java.io.*;

public class WebScrawler {
    public void getPages() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("http://www.apache.org/");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        //输出repose请求状态
        System.out.println(httpResponse.getStatusLine());

        Header[] headers = httpResponse.getAllHeaders();

        //输出get请求返回的头
        for(int i = 0;i < headers.length;i++){
            System.out.println(headers[i]);
        }
        HttpEntity entity = httpResponse.getEntity();

        if(entity != null){
            InputStream inStream = entity.getContent();
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
                System.out.println(reader.readLine());
            }catch (IOException ex){
                ex.printStackTrace();
            }catch (RuntimeException ex){
                ex.printStackTrace();
            }finally {
                inStream.close();
            }
            httpClient.getConnectionManager().shutdown();
        }


    }

    public boolean downloadPage(String path) throws HttpException,IOException{
       org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();


        InputStream input = null;
        OutputStream output = null;
        //得到post方法
        PostMethod postMethod = new PostMethod(path);
        //设置post方法参数
        NameValuePair[] postData = new NameValuePair[2];
        postData[0] = new NameValuePair("name","lietu");
        postData[1] = new NameValuePair("password","******");
        postMethod.addParameters(postData);

        int statusCode = httpClient.executeMethod(postMethod);

        if(statusCode == HttpStatus.SC_OK){
            input = postMethod.getResponseBodyAsStream();
            String filename = path.substring(path.lastIndexOf('/')+1);
            output = new FileOutputStream(filename);

            int tempByte = -1;
            while((tempByte=input.read()) > 0){
                output.write(tempByte);
            }

            if(input != null){
                input.close();
            }

            if(output != null){
                output.close();
            }

            return true;
        }

        return false;

    }

    public static void main(String args[]) throws IOException{
        WebScrawler webScrawler = new WebScrawler();
        //webScrawler.getPages();
        try{
            webScrawler.downloadPage("http://www.lietu.com/");

        }catch (HttpException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}