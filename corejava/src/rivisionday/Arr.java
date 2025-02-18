package rivisionday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Arr{
	public static void main(String[] args) {
	   List<Integer> nums=new ArrayList<>();
	   
	   Comparator<Integer> comm=new Comparator<Integer>() {
		   
		   public int compare(Integer i,Integer j) {
			   if(i%10>j%10)
			   return 1;
			   else
				   return -1;
			   
		   }
		   
	   };
	   
	   nums.add(23);
	   nums.add(19);
	   nums.add(45);
	   
	   
   Collections.sort(nums,comm);
	   
	   System.out.println(nums);
	   
	   
	   
	}
}