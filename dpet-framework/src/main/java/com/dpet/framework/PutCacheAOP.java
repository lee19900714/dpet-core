package com.dpet.framework;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dpet.commons.utils.ActionUtil;
import com.dpet.commons.utils.RedisKeyUtil;
import com.dpet.commons.vo.annotation.PutCache;

@Component
@Aspect
public class PutCacheAOP {


	@Autowired
	private JedisDAO jedisDAO;
	
	@Pointcut("@annotation(com.dpet.commons.vo.annotation.PutCache)")
	public void PutCache(){
	}
	
	/**
	 * 在所有标注@PutCache的地方切入
	 * @param joinPoint
	 */
	@After("PutCache()")
	public void AfterExec(JoinPoint joinPoint){
		//是否启用缓存
		//if (!"TRUE".equals(SystemConfig.getProperty("CACHE_ON"))) return;
		MethodSignature ms=(MethodSignature) joinPoint.getSignature();
		Method method=ms.getMethod();
		String ActionName = RedisKeyUtil.CACHE + method.getAnnotation(PutCache.class).name();
		String fieldList = method.getAnnotation(PutCache.class).value();
		for (String field:fieldList.split(",")) 
		{
			if ("user_id".equals(field))
				ActionName+=":"+ActionUtil.getUserID();
			else if ("user_type".equals(field))
				ActionName+=":"+ActionUtil.getUserType();
			else ActionName+=":"+ActionUtil.getParameter(field);
		}
		jedisDAO.incr(ActionName);
	}
}
