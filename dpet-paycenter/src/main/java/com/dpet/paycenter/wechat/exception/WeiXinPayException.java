package com.dpet.paycenter.wechat.exception;

public class WeiXinPayException extends Exception {
	private static final long serialVersionUID = 4540083833894214185L;

	public WeiXinPayException() {
	}

	public WeiXinPayException(String message) {
		super(message);
	}

	public WeiXinPayException(Throwable cause) {
		super(cause);
	}

	public WeiXinPayException(String message, Throwable cause) {
		super(message, cause);
	}

}
