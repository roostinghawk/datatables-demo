package com.liu.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.model.JsonResult;
import com.liu.demo.model.UserModel;
import com.liu.demo.service.UserService;

@Controller
public class CreateController {
	
	@Autowired
	private UserService userService;
	
    /**
     * Initialization of Home page
     */
	@RequestMapping("/create")
	public ModelAndView init(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userModel", new UserModel());
		return new ModelAndView("create", model);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("UserModel") UserModel user){
		userService.createuser(user);
		return new ModelAndView("home"); 
	}
}
