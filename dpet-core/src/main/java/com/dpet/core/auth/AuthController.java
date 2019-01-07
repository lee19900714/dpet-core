package com.dpet.core.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.core.MyBaseController;
import com.dpet.framework.JWTUtil;
import com.dpet.framework.ResponseUtils;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value = "auth")
public class AuthController extends MyBaseController {

	/**
	 * 新接口认证
	 * 
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/credentials")
	public @ResponseBody Object credentials(HttpServletRequest request,
			@RequestBody JSONObject json) {

		String expires = json.get("expires").toString();
		String id = json.getString("id");
		JSONObject role = json.getJSONObject("role");
		String role_key = role.getString("key");

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("role_key", role_key);

		if (json.has("loginInfo")) {
			JSONObject loginInfo = json.getJSONObject("loginInfo");
			if (loginInfo.has("providerKey")) {
				map.put("providerKey", loginInfo.getString("providerKey"));
			}
		}

		JSONObject userInfo = JSONObject.fromObject(map);
		return ResponseUtils.sendSuccess(JWTUtil.sign(userInfo.toString(),
				expires));
	}

}
