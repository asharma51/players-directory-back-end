package com.sb.players_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from SpringBoot: " + new java.util.Date();
	}

	@GetMapping("/process")
	public String process() {
		return "SpringBoot processing!!!!!!!";
	}
}
