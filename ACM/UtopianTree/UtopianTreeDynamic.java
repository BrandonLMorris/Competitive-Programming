//Utopian Tree non-iterative solution
//Original solution by William Hester
//Brandon Morris 9/24/14

import java.util.*;

public class UtopianTreeDynamic.java {
	
	public static final ArrayList<Integer> ints = new ArrayList<>();
	
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
		int t = inputScanner.nextInt();
		
		ints.add(1);
		
		for(int i = 0; i < t; i++){
			int n = inputScanner.nextInt();
			for(intj = ints.size() - 1; j < n; j++){
				int height = ints.get(j);
				if(j%2 == 0){
					height *= 2;
				}
				else {
					height += 1;
				}
				ints.add(height);
			}
			System.out.println(ints.get(n));
		}
	}
}