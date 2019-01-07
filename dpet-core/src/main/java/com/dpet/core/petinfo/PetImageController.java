package com.dpet.core.petinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;

/**
 * @author lee
 *
 */
@RestController
@RequestMapping(value = "ipet/petimage")
public class PetImageController extends MyBaseController {
	/**
	 * 图片上传
	 * */
	@RequestMapping("/upLoadPetImage")
	@ResponseBody
	public Object upLoadPetImage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		return ResponseUtils.sendSuccess(resultMap);
	}
}
