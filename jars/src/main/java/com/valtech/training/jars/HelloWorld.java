package com.valtech.training.jars;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	String hello(String name);

}