package com.dpet.framework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostUtil {
	private static Logger logger = LoggerFactory.getLogger(PostUtil.class);
	
    public static String doPost(String urlStr, String paramStr) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestProperty("contentType", "UTF-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		logger.info("URL:" + urlStr +";PARAM:" +paramStr.toString());
		String params = paramStr.toString();
		os.write(params.getBytes("UTF-8"));
		os.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"GBK"));
		String line;
		String result = "";
		while ((line = br.readLine()) != null) {
			result += line;
		}
		logger.info("RESULT DATA:"+result);
		br.close();
		return result;
	}
    
    public static String doPost(String urlStr, Map<String, Object> paramMap) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept-Charset", "utf-8");
		conn.setRequestProperty("contentType", "utf-8");
		String paramStr = prepareParam(paramMap);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		logger.info("URL:" + urlStr +";PARAM:" +paramStr.toString());
		String params = paramStr.toString();
		os.write(params.getBytes("UTF-8"));
		os.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String line;
		String result = "";
		while ((line = br.readLine()) != null) {
			result += line;
		}
		logger.info("RESULT DATA:"+result);
		br.close();
		return result;
	}
    
    private static String prepareParam(Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		if (paramMap.isEmpty()) return "";
		for (String key : paramMap.keySet()) {
			String value = (String) paramMap.get(key);
			if (sb.length() < 1) sb.append(key).append("=").append(value);
			else sb.append("&").append(key).append("=").append(value);
		}
		return sb.toString();
	}
}