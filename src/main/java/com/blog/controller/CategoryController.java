package com.blog.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blog.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.blog.pojo.Category;
import com.blog.service.CategoryService;
import com.blog.util.Page;

import javax.servlet.http.HttpServletRequest;

// 告诉spring mvc这是一个控制器类
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	private  static Map<String,UserInfo> usersMap=new HashMap<String,UserInfo>();
	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),5);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();

		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}
	@RequestMapping("/login2")
	public  String login(UserInfo user, HttpServletRequest request){
		user.setName("xiaoA");
		usersMap.put(user.getName(),user);
		request.getSession().setAttribute("user",user);
		request.getSession().setAttribute("usersMap",usersMap);
		return "redirect:./index.jsp";
	}

}
