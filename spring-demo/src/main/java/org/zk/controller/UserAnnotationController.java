package org.zk.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zk.core.Result;
import org.zk.domain.User;
import org.zk.web.JxlsExcelView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.dom.DOMSource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodType;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 使用DefaultAnnotationHandlerMapping
 */
@RequestMapping("/user")
@Controller
public class UserAnnotationController implements ApplicationContextAware {

	ApplicationContext applicationContext;


	private static Logger log = LoggerFactory.getLogger(UserAnnotationController.class);

	// Content-Type:
	// 最常见的表单形式 application/x-www-form-urlencoded
	// 文件上传：multipart/form-data
	// json格式：application/json
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result list(User user) {
//		if(true) {
//			throw new RuntimeException("xxx");
//		}
		return new Result();
	}





	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("resource")
	@ResponseBody
	public String resource(HttpServletRequest request) throws Exception {
		// ServletContextResource读取webapp目录下文件
		ServletContextResource resource = new ServletContextResource(request.getServletContext(), "WEB-INF/web.xml");
		String str = FileUtils.readFileToString(resource.getFile(), "UTF-8");
		log.info("读取内容为：{}", str);
		// ServletContextResource与此种写法原理一致
		InputStream in = request.getServletContext().getResourceAsStream("WEB-INF/web.xml");
		String str2 = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
		log.info("读取内容为2：{}", str2);

		// resources目录下文件用ClassPathResource读取
		// Resource resource = new ClassPathResource("jdbc.properties");

		return "ok";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
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
