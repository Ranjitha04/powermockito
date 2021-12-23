package com.powermock.demo.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Greeting.class})
@PowerMockIgnore("jdk.internal.reflect.*")
public class GreetingTest {

	@Test
	public void constuctorTest() throws Exception {
		Greeting greetingMock = Mockito.mock(Greeting.class);
		PowerMockito.whenNew(Greeting.class).withNoArguments().thenReturn(greetingMock);

	    Greeting greeting = new Greeting();

		PowerMockito.verifyNew(Greeting.class).withNoArguments();
	}
}
