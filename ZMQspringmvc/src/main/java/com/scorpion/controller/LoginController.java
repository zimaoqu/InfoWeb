package com.scorpion.controller;

import com.scorpion.pojo.adminInfo;
import com.scorpion.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Scorpion on 2017/8/18.
 * 进行登入验证
 */
@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("showLogin")
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping("login")
    public void login(adminInfo adminInfo,HttpSession httpSession,HttpServletResponse httpServletResponse) throws IOException {
        adminInfo = loginService.checkLogin(adminInfo.getUsername(),adminInfo.getPassword());
        if(adminInfo!=null){
            httpSession.setAttribute("username",adminInfo.getUsername());
            httpServletResponse.sendRedirect("/zmq/showHome");
        }else{
            httpServletResponse.sendRedirect("/Login/showLogin");
        }
    }
}
