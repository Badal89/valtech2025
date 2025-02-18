package day3;


class Mobile{
	
	static String name;
	String brand;
	int price;
	
	public void show() {
		System.out.println("Brand= "+brand+" Price="+price+" Name="+name);
	}
	public static void show(Mobile obj) {
		System.out.println("Brand= "+obj.brand+" Price="+obj.price+" Name="+name);
	}
	
	
	
}

public class Demo {

	public static void main(String[] args) {
		
		
		Mobile obj=new Mobile();
		Mobile obj1=new Mobile();
		
		obj.brand="Apple";
		obj.price=200;
		obj.name="Laptop";
		
		obj1.brand="Samsung";
		obj1.price=100;
		obj1.name="phone";
		
		Mobile.name="tablet";
		
		obj.show();
		obj1.show();
		Mobile.show(obj1);
				
				
		
		
		
		/* int nums[][]=new int[3][];
		 * 
		 * 
		nums[0]=new int[4];
		nums[1]=new int[3];
		nums[2]=new int[2];
		*/
		
		/*for(int i=0;i<3;i++) {
			for(int j=0;j<nums[i].length;j++) {
				nums[i][j] =(int)(Math.random()*100);
				
				
			}
		}
		
		
		
		Student s1=new Student();
		s1.name="badal";
		s1.id=8;
		
		Student s2=new Student();
		s2.name="ak";
		s2.id=5;
		
		Student student[]=new Student[2];
		student[0]=s1;
		student[1]=s2;
	
		
		
		for(int i=0;i<student.length;i++) {
			
			System.out.println(student[i].name+" "+student[i].id);
			
			
		}
		
		
		*/
		
		
		
	}

}
