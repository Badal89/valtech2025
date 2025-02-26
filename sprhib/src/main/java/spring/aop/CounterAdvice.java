package spring.aop;
 
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;
 
public class CounterAdvice implements MethodBeforeAdvice{
	
	
	private Map<String,Integer> counters;
	
	public void any() {
		System.out.println("Ininting counters");
		counters=new HashMap<String, Integer>();
	}
	
	public void any1() {
		System.out.println("counters="+counters);
	}
 
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Method = " +method.getName()+"With Args = "+Arrays.toString(args));
		String mathodName=method.getName();
		if(counters.containsKey(mathodName)) {
			counters.put(mathodName, counters.get(mathodName)+1);
		}else {
			counters.put(mathodName, 1);
		}
		
	}
	
	
	
}
 
 