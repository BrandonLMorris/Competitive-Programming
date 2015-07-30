//HackerRank:IsFibo
//Original Solution by Brian DeLoach
//9/24/2014

import java.util.*;

public class IsFiboSolution{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		ArrayList<Long> fibs = new ArrayList<Long>();
		fibs.add(0l);
		fibs.add(1l);
		
		while(fibs.get(fibs.size()-1)<10_000_000_000L) {
			int size = fibs.size();
			fibs.add(fibs.get(size-1) + fibs.get(size-2));
		}
		
		for (int i = 0; i < t; i++){
			System.out.println(fibs.contains(in.nextLong()) ? "IsFibo" : "IsNotFibo");
		}
	}
}