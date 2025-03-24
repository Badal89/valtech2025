package com.valtech.training.quiz.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quiz.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuizControllerTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addQuiz() {
		List quiz=restTemplate.getForObject("http://localhost:"+port+"/api/v1/quiz/", List.class);
		
		System.out.println("Adding Quiz.... to db....");
		
		
//		
//		
//		QuizVO ques1=restTemplate.postForObject
//				("http://localhost:"+port+"/api/v1/quiz/", 
//						new QuizVO(0,"Java World"),
//						QuizVO.class);
//		
		
		
		//id, quizTitle, questionIds
		
		
		
	}
	
		
	
}