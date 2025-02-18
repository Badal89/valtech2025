package day2;

public class AirthmaticImpl implements Airthmatic {
	
	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}
	
	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}
	
	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	public static void main(String[] args) {
		Airthmatic ar= new AirthmaticImpl();
		System.out.println(ar.add(5,10));
		System.out.println(ar.sub(5,10));
		System.out.println(ar.mul(5,10));
		System.out.println(ar.div(5,10));
	}

}
