package day2;

import java.util.Iterator;

public class ControlStatements {
	
	
	public void testIfElse(int a) {

		if(a%2==0) {
			System.out.println("A="+a+"is Even..");
		}else {
			System.out.println("A="+a+"is Odd..");
		}
	}
	
	
	public void testFor(int a[]){
		for (int i = 0; i < a.length; i++) {
		    System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch (a){
		   case 1:
			   System.out.println("One");
			   break;
		   case 2:
			   System.out.println("Two");
			   
		   case 3:
			   System.out.println("Three");
			   break;
		   default:
			   System.out.println("All others");
			   break;
		
			
		}
	}
	// var argument
	// var arg should be the last argument
	public int add(int iv,int ... a) {
		int sum = iv;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("sum="+sum);
		return sum;
		
	}
	
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(0);
		cs.testFor(new int[] {1,2,3});
		cs.testFor(new int[] {1,2,3,4,5});
		cs.testSwitch(1);
		cs.testSwitch(2);
		cs.add(1,2);
		cs.add(1,2,3,4);
		
	}

}
