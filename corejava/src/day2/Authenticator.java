package day2;

import java.util.*;

public class Authenticator {
    public long authenticate(String name , String pass) throws Exception{
    	if(name.equals("scott") && pass.equals("tiger")){
    		//"scott".equals(name) && "tiger".equals(pass) good to do..
    	
    		return new Random().nextLong();
    	}
    	throw new Exception("only Scott is allowed");
    }
}
