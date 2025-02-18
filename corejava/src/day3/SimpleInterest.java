package day3;

public interface SimpleInterest {
     public default double computInterest(double principal,double rateOfInterest,double duration) {
    	 return principal * rateOfInterest * duration / 100;
     }
     
}
