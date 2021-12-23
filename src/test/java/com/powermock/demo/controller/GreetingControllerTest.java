package com.powermock.demo.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.powermock.demo.entity.Greeting;
import com.powermock.demo.service.impl.GreetingServiceImpl;
import com.powermock.demo.utils.Utility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GreetingServiceImpl.class, GreetingController.class, Utility.class, Greeting.class})
@PowerMockIgnore("jdk.internal.reflect.*")
public class GreetingControllerTest {

    
	private GreetingController greetingController;
	
	@Before
	public void setUp() {
		greetingController = PowerMockito.spy(new GreetingController());
		PowerMockito.mockStatic(GreetingServiceImpl.class);
	
	}
	
	@Test
	public void getGreetingMessageTest() { 
		PowerMockito.mockStatic(GreetingServiceImpl.class);
	    PowerMockito.when(GreetingServiceImpl.getMessage()).thenReturn("Hello World");  
	      
	    String actualcall = greetingController.getGreetingMessage();
	    
	    assertEquals("Hello World", actualcall);  
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void privatemethodCalleeTest() throws Exception {
		
		PowerMockito.when(greetingController, "somePrivateMethod")
		.thenReturn("from private method");
		
		String result = greetingController.privateMethodCalee();

		assertEquals("from private method", result);
		PowerMockito.verifyPrivate(greetingController, Mockito.times(1)).invoke("somePrivateMethod");
	}
     
	
	@Test
	public void somePrivateMethodTest() throws Exception {
		String result = Whitebox.invokeMethod(greetingController, "somePrivateMethod");
		assertEquals(result, "from private method");
	}
     
	@Test
    public void staticMethodTest() {
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.finalClassMessage()).thenReturn("from final class");
       
        assertEquals(greetingController.finalMethodCallee(), "from final class");
    }
	
	@Test
	public void privateConstructorCalleeTest() throws Exception {
		Greeting greetingMock = Mockito.mock(Greeting.class);
		PowerMockito.whenNew(Greeting.class).withNoArguments().thenReturn(greetingMock);
		
		PowerMockito.spy(Greeting.class);
        PowerMockito.when(Greeting.getInstance()).thenReturn(greetingMock);
        
        
		greetingController.privateConstructorCallee();
		

		PowerMockito.verifyNew(Greeting.class).withNoArguments();
	}
	
}
