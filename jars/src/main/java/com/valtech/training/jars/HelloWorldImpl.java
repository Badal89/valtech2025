package com.valtech.training.jars;

import javax.jws.WebService;

@WebService (endpointInterface = "com.valtech.training.jars.HelloWorld",
             name = "HelloWorld",portName = "HelloWorldPort")
public class HelloWorldImpl implements HelloWorld {
	
      @Override
	public String hello(String name) {
		
		return "Hello" + name;
	}

}
