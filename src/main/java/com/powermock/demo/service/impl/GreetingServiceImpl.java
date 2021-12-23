package com.powermock.demo.service.impl;

import org.springframework.stereotype.Service;

import com.powermock.demo.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{

	public static String getMessage() {
		return "Hello World";
	}
	
	@Override
	public String getMessageNonStatic() {
		// TODO Auto-generated method stub
		return null;
	}
}
