package com.swdegao.quartz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
	public static void main(String[] args) {  
		
		//根据回调url返回数据
        String url = "https://www.baidu.com";  
        try {  
            URL oracle = new URL(url);  
            URLConnection conn = oracle.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String inputLine = null;  
            while((inputLine = br.readLine()) != null){  
                System.out.println(inputLine);  
            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
