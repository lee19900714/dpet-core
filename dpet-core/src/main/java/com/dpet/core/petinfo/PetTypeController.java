package com.dpet.core.petinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.convertors.PetTypeConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.PetTypeInfo;
import com.dpet.service.inter.PetTypeInfoService;

/**
 * The type Pet type controller.
 */
@RestController
@RequestMapping(value = "ipet/pettype")
public class PetTypeController extends MyBaseController {

	@Autowired
	private PetTypeInfoService petTypeInfoService;
	
	@Autowired
	private PetTypeConvertor petTypeConvertor;

	/**
	 * 获取宠物类型列表接口  @param request the request
	 *
	 * @return the object
	 */
	@RequestMapping("/petTypeList")
	@ResponseBody
	public Object petTypeList(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<PetTypeInfo> petTypeList = petTypeInfoService.selectAll();
		resultMap.put("petTypeList", petTypeConvertor.convertVOList(petTypeList));
		return ResponseUtils.sendSuccess(resultMap);
	}

}
