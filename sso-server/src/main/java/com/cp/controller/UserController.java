package com.cp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cp.pojo.Result;
import com.cp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Result userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Result result = userService.userLogin(username, password, request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "");
		}
	}
	
	@RequestMapping(value="/logout/{token}")
	public String logout(@PathVariable String token) {
		userService.logout(token); // 思路是从Redis中删除key，实际情况请和业务逻辑结合
		return "index";
	}
	
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token) {
		Result result = null;
		try {
			result = userService.queryUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = Result.build(500, "");
		}
		return result;
	}
}
