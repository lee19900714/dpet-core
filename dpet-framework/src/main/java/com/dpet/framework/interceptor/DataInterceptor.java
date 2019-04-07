package com.dpet.framework.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dpet.commons.Constants;
import com.dpet.commons.utils.ActionParam;
import com.dpet.commons.utils.ActionUtil;
import com.dpet.commons.utils.StringUtil;
import com.dpet.commons.vo.JWTUser;
import com.dpet.framework.BaseController;
import com.dpet.framework.JWTUtil;

import net.sf.json.JSONObject;

/**
 * 统一请求拦截器，在这里进行一些基础框架数据的处理
 *
 * @author zhusong
 */
public class DataInterceptor extends BaseController implements HandlerInterceptor {

    protected static Log logger = LogFactory.getLog(DataInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUrl = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        logger.info("**********************REQUEST-URL:" + requestUrl + "***********************");
        logger.info("**********************IP-ADRESS:" + (request.getHeader("X-Real-IP") == null ? request.getRemoteAddr() : request.getHeader("X-Real-IP")) + ",SessionID:" + request.getSession().getId());

        ActionParam p = new ActionParam(false);
        ActionUtil.setActionParam(p);
        p.setParam(getParamFromRequest(request));
        setPaginationInfo(request);

        String token = request.getHeader("x-auth-token");
        if (StringUtil.isNotEmpty(token)) {
            logger.info("**********************x-auth-token:" + token);
            saveUser2Thread(token);
        }
        return true;
    }

    /**
     * 将请求里面的所有参数设置到Param中
     *
     * @return
     */
    private HashMap<String, String> getParamFromRequest(HttpServletRequest request) {
        HashMap<String, String> param = new HashMap<String, String>();
        Map<?, ?> map = request.getParameterMap();
        for (Object key : map.keySet()) {
            logger.info("Param:" + key.toString() + "=" + request.getParameter(key.toString()));
            param.put(key.toString(), request.getParameter(key.toString()));
        }
        return param;
    }

    /**
     * 将分页参数设置到线程中
     *
     * @param request
     */
    private void setPaginationInfo(HttpServletRequest request) {
        boolean isPage = StringUtil.isNotEmpty(request.getParameter("page"));
        if (isPage) {
            Integer pageNo = Integer.parseInt(request.getParameter("page"));
            Integer pageSize = StringUtil.isEmpty(request.getParameter("pageSize")) ? Constants.DEFAULT_LIMIT : Integer.parseInt(request.getParameter("pageSize"));
            ActionUtil.setPage(isPage);
            ActionUtil.setPageNo(pageNo);
            ActionUtil.setPageSize(pageSize);
        }
    }

    /**
     * 将用户信息存入线程中
     *
     * @return
     */
    private void saveUser2Thread(String token) {
        try {
            String userInfo = JWTUtil.unsign(token);
            JSONObject userInfoJson = JSONObject.fromObject(userInfo);
            JWTUser user = new JWTUser();
            user.setUser_id(userInfoJson.getString("id"));
            if (userInfoJson.has("providerKey")) {
                user.setProvider_key(userInfoJson.getString("providerKey"));
                logger.info("**********************providerKey:" + user.getProvider_key());
            }
            ActionUtil.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }
}
