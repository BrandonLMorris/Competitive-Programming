/*Sherlock and the GCD
*HackerRank:Algorithms:Warmup
*Created 9/30/14
*Given a list of integers, find if any two are coprime
*If a pair of coprime integers is found, print YES. If not, print NO
*/
import java.util.*;

public class SherlockAndGCD{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		//final long startTime = System.currentTimeMillis();
		for(int i = 0; i < t; i++){
			int n = input.nextInt();
			int[] a = new int[n];
			for(int j = 0; j < n; j++){
				a[j] = input.nextInt();
			}
			
			//Arrays.sort(a);
			
			boolean bFound = false;
			for(int j = 0; j <= n -2; j++){
				for(int k = j+1; k <= n -1; k++){			// //nested loop iterates through every pair, order irrelevent
					if((isPrime(a[j]) && isPrime(a[k])) || (areCoprime(a[j],a[k]))){
						bFound = true;
					}
			// 		isACoprime = true;
			// 		System.out.println("Testing a[" + j + "][" + k + "]");
			// 		for(int l = 2; l <= a[j]; l++){				//iterates for every x(x>1) to see if will divide pair
			// 			if(a[j]%l == 0 && a[k]%l == 0){
			// 				isACoprime = false;
			// 			}
			// 		}
					if(isACoprime) break;
				}
				if(isACoprime) break;
			}
			if(isACoprime) System.out.println("YES");
			else System.out.println("NO");
			//final long endTime = System.currentTimeMillis();
			//System.out.println("Program execution: " + (endTime - startTime));
			
			// boolean isGCD = false;
// 			for(int j = 2; j < a[a.length -1]; j++){
// 				isGCD = true;
// 				for(int k = 0; k < a.length -1; k++){
// 					if(j > a[k]) continue;
// 					if (a[k]%j != 0) isGCD = false;
// 				}
// 				if(isGCD){
// 					System.out.println("NO");
// 					break;
// 				}
// 			}
// 			if(!isGCD) System.out.println("YES");

		}
	}
	
	public static boolean isPrime(int x){
		if(x == 1 || x == 2) return true;
		for(int i = 2; i < x; i++){
			if(x % i == 0) return false;
		}
		return true;
	}
	public static boolean areCoprime(int x, int y){
		int n;
		if(x>y) n = x;
		else n = y;
		for(int i = 2; i < n; i++){
			if(x%i == 0 && y%i == 0) return false;
		}
	}
}
