package org.zk.controller;

import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user")
public class UserController {

	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

}
