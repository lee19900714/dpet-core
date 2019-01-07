package com.dpet.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class GDPhoneUtil {
	private static String http(String url, Map<String, String> params) throws IOException {
		URL u = null;
		HttpURLConnection con = null;

		StringBuffer sb = new StringBuffer();
		if (params != null) {
			for (Map.Entry<String, String> e : params.entrySet()) {
				sb.append((String) e.getKey());
				sb.append("=");
				sb.append((String) e.getValue());
				sb.append("&");
			}
			sb.substring(0, sb.length() - 1);
		}
		u = new URL(url);
		con = (HttpURLConnection) u.openConnection();

		con.setConnectTimeout(30000);

		con.setReadTimeout(30000);
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		osw.write(sb.toString());
		osw.flush();
		osw.close();
		if (con != null) {
			con.disconnect();
		}

		StringBuffer buffer = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "GBK"));
		String temp;
		while ((temp = br.readLine()) != null) {
			buffer.append(temp);
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public static void sendMessage(String phoneNum, String content) {
		String EncoderContent = "";
		try {
			EncoderContent = URLEncoder.encode(content + "【保车连】", "GBK");
			EncoderContent = URLEncoder.encode(EncoderContent, "GBK");
			Map<String, String>map = new HashMap<String, String>();
			String url = "http://221.179.180.158:9008/HttpQuickProcess/submitMessageAll";
			map.put("OperID", "bjtwy");
			map.put("OperPass", "vXQGbG6K");
			map.put("AppendID", "");
			map.put("DesMobile", phoneNum);
			map.put("Content", EncoderContent);
			http(url, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
