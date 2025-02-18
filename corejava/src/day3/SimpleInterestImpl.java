package day3;

public class SimpleInterestImpl implements SimpleInterest {
	
	public static void main(String[] args) {
		SimpleInterest si=new SimpleInterestImpl();
		System.out.println(si.computInterest(2000,12,3));
		SimpleInterest newSi=new SimpleInterest() {
			
		@Override
		public double computInterest(double principal, double rateOfInterest, double duration) {
			// TODO Auto-generated method stub
			return SimpleInterest.super.computInterest(principal, rateOfInterest, duration);
		}
			
		};
		System.out.println(newSi.computInterest(2000, 12, 3));
		
	//	SimpleInterest lambdaSi = (p,r,d) ->p*d*r/100;
		
	}

}
