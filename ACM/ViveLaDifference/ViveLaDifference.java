//Vive La Difference
//ACM practice (9/3)

import java.util.*;

public class ViveLaDifference {
	
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		//int a, b, c, d;
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		
		int counter = 0;
		
		while(!(a == 0 && b == 0 && c == 0 && d == 0)){
			
			while(!(a == b && b == c && c == d)){
				int a1 = Math.abs(a - b);
				int b1 = Math.abs(b - c);
				int c1 = Math.abs(c - d);
				int d1 = Math.abs(d - a);
				
				counter++;
				
				a = a1;
				b = b1;
				c = c1;
				d = d1;	
			}
			System.out.println(counter);
			counter = 0;
			
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			d = input.nextInt();
		}
		
	}
	
}
