package com.dpet.wechat;

public class WeiXinException extends Exception {
	private static final long serialVersionUID = 4540083833894214185L;

	public WeiXinException() {
	}

	public WeiXinException(String message) {
		super(message);
	}

	public WeiXinException(Throwable cause) {
		super(cause);
	}

	public WeiXinException(String message, Throwable cause) {
		super(message, cause);
	}

}
