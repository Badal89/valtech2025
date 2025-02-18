package day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreadTest {

	@Test
	void test() {
		Runnable r=new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			}
		
	};
	new Thread(r).start();
	new Thread(r).start();
	new Thread(r).start();
	new Thread(r).start();
	new Thread(r).start();
	//never execute run method every should execute with start method
	
	Thread t = new Thread() {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread()+" "+i);
		}
		};
	};
	t.start();

	
	
	}
}
