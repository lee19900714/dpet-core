package com.dpet.core.petinfo;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dpet.commons.utils.FileUtil;
import com.dpet.commons.utils.UUIDUtil;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.PetImageInfo;
import com.dpet.service.inter.PetImageInfoService;

/**
 * The type Pet image controller.
 *
 * @author lee
 */
@RestController
@RequestMapping(value = "ipet/petimage")
public class PetImageController extends MyBaseController {

	@Value("${image.petImageFilePath}")
	private String petImageFilePath;

	@Autowired
	private PetImageInfoService petImageInfoService;

	/**
	 * 宠物图片上传
	 *
	 * @param petImage the pet image
	 * @param request  the request
	 * @return the object
	 * @throws IOException the io exception
	 * @throws Exception   the exception
	 */
	@RequestMapping(value = "/upLoadPetImage", method = { RequestMethod.POST })
	@ResponseBody
	public Object upLoadPetImage(@RequestParam("petImage") MultipartFile petImage, HttpServletRequest request)
			throws IOException, Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String contentType = petImage.getContentType(); // 图片文件类型
		String petId = request.getParameter("petId");
		String fileName = UUIDUtil.getUUID() + "." + contentType; // 图片名字
		FileUtil.uploadFile(petImage.getBytes(), petImageFilePath, fileName);
		PetImageInfo imageInfo = getImageInfo(petImage, fileName, petId);
		petImageInfoService.insert(imageInfo);
		return ResponseUtils.sendSuccess(resultMap);
	}

	private PetImageInfo getImageInfo(MultipartFile petImage, String fileName, String petId) {
		PetImageInfo petImageInfo = new PetImageInfo();
		Date date = new Date();
		petImageInfo.setId(fileName);
		petImageInfo.setCheckedOpinion(StringUtils.EMPTY);
		petImageInfo.setCheckedTime(date);
		petImageInfo.setChecker(StringUtils.EMPTY);
		petImageInfo.setCreateId(getMyselfId());
		petImageInfo.setCreateTime(date);
		petImageInfo.setIsChecked(0);
		petImageInfo.setModifyTime(date);
		petImageInfo.setPetId(petId);
		petImageInfo.setPetImageUrl(petImageFilePath + fileName);
		return petImageInfo;
	}

	/**
	 * Gets pet image file path.
	 *
	 * @return the pet image file path
	 */
	public String getPetImageFilePath() {
		return petImageFilePath;
	}

	/**
	 * Sets pet image file path.
	 *
	 * @param petImageFilePath the pet image file path
	 */
	public void setPetImageFilePath(String petImageFilePath) {
		this.petImageFilePath = petImageFilePath;
	}

}
