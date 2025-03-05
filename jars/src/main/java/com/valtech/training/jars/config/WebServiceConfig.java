package com.valtech.training.jars.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.jars.HelloWorldImpl;
import com.valtech.training.jars.services.MovieService;
import com.valtech.training.jars.webservices.MovieServiceWSImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint movieServiceWS(MovieService movieService) {
		EndpointImpl endpoint=new EndpointImpl(bus,new MovieServiceWSImpl(movieService));
		endpoint.setAddress("/movieService");
		endpoint.publish();
		return endpoint;
	}
	
	@Bean
	public Endpoint helloWorldWebService() {
		EndpointImpl endPoint= new EndpointImpl(bus,new HelloWorldImpl());
		endPoint.setAddress("/helloWorld");
		endPoint.publish();
		return endPoint;
		
		
		
	}
	

}
