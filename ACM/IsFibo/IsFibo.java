//Is Fibo attempt
//Solution finished from Brian DeLoach's solution
//9/24/2014

import java.util.*;

public class IsFibo {
	
	public static final ArrayList<Long> longs = new ArrayList<>();
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();
		
		longs.add(0);
		longs.add(1);
			
		while(10000000000 > longs.get(longs.size()-1)){
			longs.add(longs.get(longs.size()-1)+longs.get(longs.size()-2));
		}
		
		for(int i = 0; i < t; i++){
			long n = input.nextInt();
			for(int j)
		}
		
	}
}