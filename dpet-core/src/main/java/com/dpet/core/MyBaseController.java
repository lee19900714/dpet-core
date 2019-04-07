package com.dpet.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dpet.commons.DpetCode;
import com.dpet.commons.MessageConstants;
import com.dpet.commons.utils.ActionUtil;
import com.dpet.commons.vo.JWTUser;
import com.dpet.framework.BusinessException;
import com.dpet.framework.CacheException;
import com.dpet.framework.LoginException;
import com.dpet.framework.MsgService;
import com.dpet.framework.ResponseUtils;

/**
 * 用来统一封装异常信息，可以在产生异常的时候同时将错误信息进行封装成需要的格式：比如JSON、XML等
 * 
 * @author zhusong
 */
public class MyBaseController {

	private static Log logger = LogFactory.getLog(MyBaseController.class);
	
	public final int pageNum = 1;
	
	public final int pageSize = 10;

	/**
	 * 异常控制，这便是异常细节可控，将来可用于支持国际化（异常信息国际化）
	 **/
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Object handleException(Exception ex,
			HttpServletRequest request) {
		// 写入错误日志
		logger.error(ex.getMessage(), ex);
		if (ex instanceof CacheException)
			return ResponseUtils.sendFailure(DpetCode.ServerErrMsg,
					DpetCode.ServerErr);
		else if (ex instanceof LoginException)
			return ResponseUtils.sendFailure(DpetCode.AuthErrMsg,
					DpetCode.AuthErr);
		else if (ex instanceof BusinessException)
			return ResponseUtils.sendFailure(ex.getMessage(),
					DpetCode.ServerErr);
		else
			return ResponseUtils.sendFailure(
					MsgService.getMsg(MessageConstants.UNEXPECTED_EXCEPTION),
					DpetCode.ServerErr);
	}

	protected JWTUser getMyself() {
		return ActionUtil.getUser();
	}

	protected String getMyselfId() {
		return ActionUtil.getUser().getUser_id();
	}

	protected String getMyOpenId() {
		return ActionUtil.getUser().getProvider_key();
	}


	/**
	 * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
	 * 
	 * @param request
	 * @return ip
	 */
	protected static String getLocalIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String forwarded = request.getHeader("X-Forwarded-For");
		String realIp = request.getHeader("X-Real-IP");

		String ip = null;
		if (realIp == null) {
			if (forwarded == null) {
				ip = remoteAddr;
			} else {
				ip = remoteAddr + "/" + forwarded.split(",")[0];
			}
		} else {
			if (realIp.equals(forwarded)) {
				ip = realIp;
			} else {
				if (forwarded != null) {
					forwarded = forwarded.split(",")[0];
				}
				ip = realIp + "/" + forwarded;
			}
		}
		return ip;
	}

}
