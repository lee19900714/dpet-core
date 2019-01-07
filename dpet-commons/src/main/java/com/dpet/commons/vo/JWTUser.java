package com.dpet.commons.vo;

public class JWTUser {
	
	private String user_id;
	
	private String role_key;
	
	private String provider_key;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRole_key() {
		return role_key;
	}

	public void setRole_key(String role_key) {
		this.role_key = role_key;
	}

	public String getProvider_key() {
		return provider_key;
	}

	public void setProvider_key(String provider_key) {
		this.provider_key = provider_key;
	}
}
