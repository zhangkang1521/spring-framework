package org.zk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@RequestMapping("/user")
public class UserController extends AbstractController {

//	@RequestMapping("hello")
//	public String hello() {
//		return "hello";
//	}

//	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("hello", "username", "zk");
	}
}
