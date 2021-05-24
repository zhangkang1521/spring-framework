package org.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class DemoController {

	@RequestMapping("locale-demo")
	public String localeDemo() {
		return "locale-demo";
	}

	@RequestMapping("theme-demo")
	public String themeDemo() {
		return "theme-demo";
	}
}
