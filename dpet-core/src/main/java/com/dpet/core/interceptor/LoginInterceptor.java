package com.dpet.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dpet.commons.utils.ActionUtil;
import com.dpet.framework.BaseController;
import com.dpet.framework.LoginException;

/**
 * 登录拦截器
 * @author zhusong
 */

public class LoginInterceptor extends BaseController implements HandlerInterceptor{
	
	protected static Log logger = LogFactory.getLog(LoginInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler)  throws Exception {
		
		if(ActionUtil.getUser() == null){
			logger.info("**********************登录拦截:"+request.getRequestURI()+"***********************");
			throw new LoginException("您还未登陆，请先登录系统");
		}
		
		return true;
	}
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}
}
