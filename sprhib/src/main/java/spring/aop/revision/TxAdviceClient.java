package spring.aop.revision;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxAdviceClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appctx=new ClassPathXmlApplicationContext("tx-advice.xml");

	}

}
