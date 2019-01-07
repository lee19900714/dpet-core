package com.dpet.framework;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.dpet.commons.utils.DateUtil;

public class JWTUtil {
	private static final String SECRET = "fGhre3$56%43erfkl8)/§$zhusong2sai2*6)!(";

	private static final String EXP = "exp";

	private static final String PAYLOAD = "user_info";

	// 加密
	public static String sign(String jsonString, String expires) {
		try {
			final JWTSigner signer = new JWTSigner(SECRET);
			final Map<String, Object> claims = new HashMap<String, Object>();
			Date expTime = DateUtil.dateTimeFormat(expires);
			claims.put(PAYLOAD, jsonString);
			claims.put(EXP, expTime.getTime());
			return signer.sign(claims);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 解密
	public static String unsign(String jwt) {
		JWTVerifier verifier = new JWTVerifier(SECRET);
		try {
			Map<String, Object> claims = verifier.verify(jwt);
			if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
				long exp = (Long) claims.get(EXP);
				long currentTimeMillis = System.currentTimeMillis();
				if (exp > currentTimeMillis) {
					return (String) claims.get(PAYLOAD);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	class User{
		String id;
		String role_key;
		String providerKey;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getRole_key() {
			return role_key;
		}
		public void setRole_key(String role_key) {
			this.role_key = role_key;
		}
		public String getProviderKey() {
			return providerKey;
		}
		public void setProviderKey(String providerKey) {
			this.providerKey = providerKey;
		}
		
	}
	
	public static void main(String[] args){
		JWTUtil jwt = new JWTUtil();
		User user = jwt.new User();
		user.setId("123456");
		user.setProviderKey("asdasd");
		user.setRole_key("1102");
		String token = jwt.sign(JSONObject.toJSONString(user), "2019-12-30 00:00:00");
		System.out.println(token);
	}
}
