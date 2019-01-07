package com.dpet.core.petinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.commons.utils.DateUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.PetInfoConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.PetInfo;
import com.dpet.service.inter.PetInfoService;
import com.dpet.vo.PetInfoVO;

/**
 * @author lee 宠物信息操作接口
 */
@RestController
@RequestMapping(value = "ipet/petinfo")
public class PetController extends MyBaseController {

	private static Log logger = LogFactory.getLog(PetController.class);

	@Autowired
	private PetInfoService petInfoService;

	@Autowired
	private PetInfoConvertor petInfoConvertor;

	/**
	 * 上传宠物信息
	 * 
	 * @param petInfo
	 * @return
	 */
	@RequestMapping(value = "/upLoadPetInfo", method = { RequestMethod.POST })
	@ResponseBody
	public Object upLoadPetInfo(@RequestBody PetInfoVO petInfoVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 数据完整性校验 不做 提高用户体验
		// 数据格式校验
		PetInfo p = this.getPetInfo(petInfoVO);
		p.setUserId(getMyselfId());
		// 幂等性校验
		List<PetInfo> petCheck = petInfoService.selectByUserId(getMyselfId());
		if (CollectionUtils.isNotEmpty(petCheck)) {
			logger.info("新增失败，已存在宠物关联记录");
			resultMap.put("petInfo", petInfoConvertor.convertVOList(petCheck));
		} else {
			petInfoService.insert(p);
			logger.info("新增成功");
			resultMap.put("petInfo", petInfoConvertor.convertVO(p));
		}
		return ResponseUtils.sendSuccess(resultMap);
	}

	private PetInfo getPetInfo(PetInfoVO petInfoVO) {
		Date date = new Date();
		petInfoVO.setId(UUIDUtil.getUUID());
		petInfoVO.setCreateTime(DateUtil.formatDateToString(date, DateUtil.Y_M_D_HMS));
		petInfoVO.setModifyTime(DateUtil.formatDateToString(date, DateUtil.Y_M_D_HMS));
		return petInfoConvertor.convertModel(petInfoVO);
	}

	@RequestMapping(value = "/myPetInfo", method = { RequestMethod.GET })
	@ResponseBody
	public Object petInfo(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PetInfo petInfo = petInfoService.selectByUserId(getMyselfId()).get(0);
		resultMap.put("petInfo", petInfoConvertor.convertVO(petInfo));
		return ResponseUtils.sendSuccess(resultMap);
	}
	
	
}
