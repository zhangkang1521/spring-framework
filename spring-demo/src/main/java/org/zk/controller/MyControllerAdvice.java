package org.zk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zk.core.Result;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class MyControllerAdvice {

	private static Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

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

	// 返回页面视图，@ResponseBody如何区分开来？
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handleException(Exception e, HttpServletRequest request){
		Result result = new Result();
		if (e instanceof BindException) {
			StringBuilder errMessage = new StringBuilder();
			BindException bindException = (BindException)e;
			List<FieldError> fieldErrors = bindException.getBindingResult().getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				errMessage.append(fieldError.getDefaultMessage());
				errMessage.append(";");
			}
			result.setSuccess(false);
			result.setMessage(errMessage.toString());
		} else {
			logger.error("系统错误：", e);
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
