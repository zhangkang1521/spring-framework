package org.zk.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class MyControllerAdvice {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields("name"); // 不绑定name属性
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor());

		// 此处使用Spring内置的CustomDateEditor
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// 所有request方法之前执行
//	@ModelAttribute("aa")
//	public String init() {
//		return "aa is ok";
//	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e, HttpServletRequest request){
		request.setAttribute("msg", e.getMessage());
		return new ModelAndView("error", null);
	}

}
