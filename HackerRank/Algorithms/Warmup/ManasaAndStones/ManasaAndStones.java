/*
Manasa and Stones
HackerRank:Algorithms:Warmup
created 9/30/14
*/
import java.util.*;

public class ManasaAndStones {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();
		for(int i = 0; i < t; i++){
			ArrayList<Integer> lastStones = new ArrayList<Integer>();
			int n = input.nextInt();
			int a = input.nextInt();
			int b = input.nextInt();
			
			for(int numberOfBs = 0; numberOfBs < n; numberOfBs++){
				int counter = 0;
				int numberOfAs = (n-1) - numberOfBs;
				for(int j = 0; j < numberOfAs; j++){
					counter += a;
				}
				for(int j = 0; j < numberOfBs; j++){
					counter += b;
				}
				if(!lastStones.contains(counter)) lastStones.add(counter);
			}
			Collections.sort(lastStones);
			for(int j = 0; j < lastStones.size(); j++){
				if(j != lastStones.size()-1)
					System.out.print(lastStones.get(j) + " ");
				else System.out.println(lastStones.get(j));
			}
		}
	}
}