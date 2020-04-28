package org.zk.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e, HttpServletRequest request){
		request.setAttribute("msg", e.getMessage());
		return new ModelAndView("error", null);
	}

}
