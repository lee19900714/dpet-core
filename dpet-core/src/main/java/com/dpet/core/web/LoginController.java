package com.dpet.core.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Login controller.
 * @author lijun
 */
@RestController
@RequestMapping(value = "web")
public class LoginController {

    @RequestMapping("/login")
    public @ResponseBody Object login(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/login");
        return  mav;
    }


    @RequestMapping("/index")
    public @ResponseBody Object index(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index");
        return  mav;
    }

}
