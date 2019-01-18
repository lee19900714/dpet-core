package com.dpet.core.proposal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpet.commons.utils.UUIDUtil;
import com.dpet.convertors.ProposalConvertor;
import com.dpet.core.MyBaseController;
import com.dpet.framework.ResponseUtils;
import com.dpet.model.Proposal;
import com.dpet.service.inter.ProposalService;
import com.dpet.vo.ProposalVO;

/**
 * The type Proposal controller.
 */
@RestController
@RequestMapping(value = "ipet/proposal")
public class ProposalController extends MyBaseController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private ProposalConvertor proposalConvertor;

    /**
     * 意见反馈
     *
     * @param proposalVO the proposal vo
     * @return the object
     */
    @RequestMapping(value = "/feedback")
    @ResponseBody
    public Object feedback(ProposalVO proposalVO) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Proposal model = proposalConvertor.convertModel(proposalVO);
        model.setId(UUIDUtil.getUUID());
        model.setCreateTime(new Date());
        model.setCreateId(getMyselfId());
        proposalService.insert(model);
        return ResponseUtils.sendSuccess(resultMap);
    }

}
