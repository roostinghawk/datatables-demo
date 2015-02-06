package com.liu.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtensionController {
	
    /**
     * Initialization of extension page
     */
	@RequestMapping(value = { "/extension"})
	public ModelAndView init(HttpServletRequest request) {
		return new ModelAndView("extension");
	}
}
