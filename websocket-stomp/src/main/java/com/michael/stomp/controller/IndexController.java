package com.michael.stomp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/socket")
	public String socket() {
		return "socket";
	}
	
}
