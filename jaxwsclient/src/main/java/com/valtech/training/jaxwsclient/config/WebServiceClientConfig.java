package com.valtech.training.jaxwsclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.valtech.training.jars.HelloWorld;
import com.valtech.training.jars.webservices.MovieServiceWS;
 
@Configuration
public class WebServiceClientConfig {
	
	@Bean
	public MovieServiceWS createMovieService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(MovieServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.jars.training.valtech.com/",
				"MovieServiceWSImplService"));
		proxy.setAddress("http://localhost:8080/services/movieService");
		return proxy.create(MovieServiceWS.class);
	}
	
	
	@Bean
	public HelloWorld createHelloWorldService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(HelloWorld.class);
		proxy.setServiceName(new QName("http://jars.training.valtech.com/","HelloWorldImplService"));
		proxy.setAddress("http://localhost:8080/services/helloWorld");
		return proxy.create(HelloWorld.class);
	}
	
}
 