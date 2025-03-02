package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
//@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
    
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	
	
	
	@Test
	void testArithmetic() {
		assertEquals(10,arithmetic.add(4, 6));
		assertEquals(200,simpleInterest.compute(200,10,10));	
	}
	
	@Test
	void testBook() {
		assertEquals(6, bookService.findAll().size());
		assertEquals(5, bookService.getBooksByYearBetween(2000,2006).size());
		assertEquals(3, bookService.getBooksByPriceGreaterThan(100).size());
		assertEquals(2, bookService.findAllPriceByAuthorsId(1).size());
		System.out.println(bookService.findAllPriceByAuthorsId(1));
		System.out.println(bookService.getBookInfoByAuthor(2));
	}

	
	
	@Test
    //@Rollback()
	void questionService() {
		
		
		assertEquals(6,questionService.countByTopic("Gk"));
		assertEquals(6,questionService.countByTopic("Java"));
		assertEquals(2,questionService.countByTopicAndQuestionTextContains("Java","Exception"));
		assertEquals(3,questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		
		
	}
	

	
@Test
@BeforeEach
	void initData() {
 	long count=questionService.count();
    if(count!=0) return;
 
 
		
		Question q=questionService.saveQuestion
		(new Question("What is the color of Sky?","Red","Blue","Green","white","Blue","Gk"));
		
		questionService.saveQuestion
		(new Question("What is the color of Mars?","Red","Blue","Green","white","Red","Gk"));
		
		questionService.saveQuestion
		(new Question("What is the color of Moon?","Red","Blue","Green","white","White","Gk"));
		
		questionService.saveQuestion
		(new Question("What is the color of Jupiter?","Red","Blue","Green","white","yellow","Gk"));
		
		questionService.saveQuestion
		(new Question("What is the color of Saturn?","Red","Blue","Green","white","Blue","Gk"));
		
		questionService.saveQuestion
		(new Question("What is the color of Venus?","Red","Blue","Green","white","white","Gk"));
		
		 //questions related to java
		questionService.saveQuestion
		(new Question("What is the Super Class Of Exception ?","Object","Exception","Throwable","Error","Object","Java"));
		
		questionService.saveQuestion
		(new Question("Which class is used to create Dynamic strings?","String","DynamicString","StringBuilder","Builder","StringBuilder","Java"));
		
		questionService.saveQuestion
		(new Question("How Many Methods are there in Marker Interface?","None","One","Two","Many","None","Java"));
		
		questionService.saveQuestion
		(new Question("How Many Methods are there  in Functional Interface?","None","One","Two","Many","Yes","Java"));
		
		questionService.saveQuestion
		(new Question("can an Interface have Private Method?","Yes","No","May Be","No method can be there in interface","One","Java"));
		
		questionService.saveQuestion
		(new Question("Which subclass of Exception is not checked by the compiler ?","Exception","Error","RunTime Exceptions","Compile Time Exceptions","RunTime Exceptions","Java"));
	
		
	}

}
