package rivisionday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=null;
		try {
		InputStreamReader in= new InputStreamReader(System.in);
	
		br=new BufferedReader(in);
		
		int num=Integer.parseInt(br.readLine());
		}
		finally {
			br.close();
		}
		
		
	}
}

