package org.zk.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zk.domain.User;
import org.zk.web.JxlsExcelView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 使用DefaultAnnotationHandlerMapping
 */
@RequestMapping("/user")
public class UserAnnotationController {

	@RequestMapping("/hello")
	public String hello1(Model model, HttpServletRequest request) {
		model.addAttribute("username", "zk");
		model.addAttribute("year", "2020");
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUsername("zk" + i);
			user.setAge(10 +i);
			users.add(user);
		}
		model.addAttribute("users", users);
		request.setAttribute(JxlsExcelView.DOWNLOAD_FILE_NAME, "测试.xls");
		return "hello";
	}

	@RequestMapping("/hello2")
	@ResponseBody
	public User hello2() {
		return new User(1, "zk");
	}

	@RequestMapping("/hello3")
	public void hello() {

	}

	@RequestMapping("/jxls")
	public String jxls(Model model, HttpServletRequest request) {
		model.addAttribute("year", "2020");
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUsername("zk" + i);
			user.setAge(10 +i);
			users.add(user);
		}
		model.addAttribute("users", users);
		request.setAttribute(JxlsExcelView.DOWNLOAD_FILE_NAME, "测试.xls");
		return "demo-template";
	}

}
