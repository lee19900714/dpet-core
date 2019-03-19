package com.dpet.core.web;

import com.dpet.convertors.ProposalConvertor;
import com.dpet.model.Proposal;
import com.dpet.service.inter.ProposalService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Feed back controller.
 * @author lijun
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "feedback")
public class FeedBackController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private ProposalConvertor proposalConvertor;

    @RequestMapping("/feedbacklist")
    public @ResponseBody
    Object list(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int pageNums = request.getParameter("pageNum") == null ? 10 : Integer.parseInt(request.getParameter("pageNum"));
        Page<Proposal> proposals = proposalService.selectAll(pageNums, 10);
        mav.addObject("pageNum", proposals.getPageNum());
        mav.addObject("pageSize", proposals.getPageSize());
        mav.addObject("page", proposals.getPages());
        mav.addObject("total", proposals.getTotal());
        mav.addObject("proposals", proposalConvertor.convertVOList(proposals.getResult()));
        mav.setViewName("/feedbacklist");
        return mav;
    }

}
