package com.blog.controller;

import com.blog.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
public class Login {
    @RequestMapping("/login")
    public  String login(UserInfo user, HttpServletRequest request){

        return "redirect:./html/user/login.html";
    }
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String    doLogin( HttpServletRequest request,HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(request.getParameter("id"));
        userInfo.setPwd(request.getParameter("pwd"));
        System.out.println(userInfo.toString());
        session.setAttribute("user",userInfo);
       return "index";
    }
}
