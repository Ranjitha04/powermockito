package com.powermock.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powermock.demo.entity.Greeting;
import com.powermock.demo.service.GreetingService;
import com.powermock.demo.service.impl.GreetingServiceImpl;
import com.powermock.demo.utils.Utility;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greetings")
	public String getGreetingMessage() {
		return GreetingServiceImpl.getMessage();
	}
	
	public String getGreetingMessageFromImpl() {
		return greetingService.getMessageNonStatic();
	}
	
	public String privateMethodCalee() {
		return somePrivateMethod();
	}
	
	private String somePrivateMethod() {
		return "from private method";
	}
	
	public String finalMethodCallee() {
		return Utility.finalClassMessage();
	}

	public Greeting privateConstructorCallee() {
		return Greeting.getInstance().printMessage();
	}
}
