package com.liu.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.model.JsonResult;
import com.liu.demo.model.UserModel;
import com.liu.demo.service.UserService;

@Controller
public class OrderController {
	
	@Autowired
	private UserService userService;
	
    /**
     * Initialization of Home page
     */
	@RequestMapping(value = { "/order"})
	public ModelAndView init(HttpServletRequest request) {
		return new ModelAndView("order");
	}
	
	@RequestMapping("/order/getUsers")
	@ResponseBody
	public JsonResult getUsers(HttpServletRequest request) {
		JsonResult result = new JsonResult();
		
		// get parameters
		UserModel user = this.getUserModel(request);

		// get all count
		int recordsTotal = userService.countAllUser();
		// get count
		int recordsFiltered = userService.countUser(user);
		// get users
		List<UserEntity> users = userService.getUsers(user);
		
		result.setData(users);
		result.setDraw(user.getDraw());
		result.setRecordsFiltered(recordsFiltered);
		result.setRecordsTotal(recordsTotal);
		
		return result;
	}
	
	private UserModel getUserModel(HttpServletRequest request){
		int draw, start, length;
		
		// must parse draw to integer to prevent Cross Site Scripting (XSS) attacks 
		try{
			draw = Integer.parseInt(request.getParameter("draw"));
			start = Integer.parseInt(request.getParameter("start"));
			length = Integer.parseInt(request.getParameter("length"));
		} catch (NumberFormatException ex){
			return null;
		}
		
		String searchText = request.getParameter("search[value]");
		//String orderIndex
		int index = 0;
		Map<Integer, String> orders = new HashMap<Integer, String>();
		String colIndex = request.getParameter("order[0][column]");
		while(colIndex != null) {
			// get direction
			String dir = request.getParameter("order[" + index + "][dir]");
			orders.put(Integer.parseInt(colIndex), dir);
			
			// get next order
			index ++;
			colIndex = request.getParameter("order[" + index + "][column]");
		}
		
		UserModel user = new UserModel();
		user.setDraw(draw);
		user.setStart(start);
		user.setLength(length);
		user.setSearchText(searchText);
		user.setOrders(orders);
		
		return user;
	}
}
