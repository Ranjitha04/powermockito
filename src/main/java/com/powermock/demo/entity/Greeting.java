package com.powermock.demo.entity;

public class Greeting {
    
	public static Greeting INSTANCE;
	private String message;
	private String mode;
	
	public Greeting() {}
	
	public Greeting(String message, String mode) {
		super();
		this.message = message;
		this.mode = mode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public static Greeting getInstance() {
		return new Greeting();
	}

	public Greeting printMessage() {
		return this;
	}

}
