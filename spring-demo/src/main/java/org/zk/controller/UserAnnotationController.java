package org.zk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zk.core.Result;
import org.zk.domain.User;
import org.zk.web.JxlsExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.dom.DOMSource;
import java.lang.invoke.MethodType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 使用DefaultAnnotationHandlerMapping
 */
@RequestMapping("/user")
@Controller
public class UserAnnotationController {




	// Content-Type:
	// 最常见的表单形式 application/x-www-form-urlencoded
	// 文件上传：multipart/form-data
	// json格式：application/json
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result list(User user) {
		if(true) {
			throw new RuntimeException("xxx");
		}
		return new Result();
	}





	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

//
//	@RequestMapping("/jxls")
//	public String jxls(Model model, HttpServletRequest request) {
//		model.addAttribute("year", "2020");
//		List<User> users = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			User user = new User();
//			user.setUsername("zk" + i);
//			user.setAge(10 +i);
//			users.add(user);
//		}
//		model.addAttribute("users", users);
//		request.setAttribute(JxlsExcelView.DOWNLOAD_FILE_NAME, "测试.xls");
//		return "demo-template";
//	}

}
