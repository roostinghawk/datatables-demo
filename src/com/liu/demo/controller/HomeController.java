package com.liu.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
    /**
     * Initialization of Home page
     */
	@RequestMapping("/home")
	public ModelAndView init(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		// --- get my periods(one or two)
		List<UserEntity> users = homeService.getUsers();
		
		model.put("Users", users);

       
		return new ModelAndView("home", model);
	}
}
