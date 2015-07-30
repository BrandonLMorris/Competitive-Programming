//14
//ACM Star Simulations
//Created 10/7/2014
//Brandon Morris

import java.util.*;

public class StarSimulations{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();				//n is the number of stars in the system
		while(n != 0){
			long k = input.nextInt();			//k is the maximum distance we care about
			long distanceSquared =(long) k*k;		//distanceSquared prevents taking square root in distance formula
			int pairCounter = 0;
			long[][] stars = new long[n][3];
			for(int i = 0; i < n; i++){
				stars[i][0] = input.nextInt();
				stars[i][1] = input.nextInt();
				stars[i][2] = input.nextInt();
			}

			for(int i = 0; i < n-1; i++){
				for(int j = i+1; j < n; j++){
					long xDist = stars[i][0]-stars[j][0];
					if(xDist > distanceSquared) continue;
					long yDist = stars[i][1]-stars[j][1];
					if(yDist > distanceSquared) continue;
					long zDist = stars[i][2]-stars[j][2];
					if(zDist > distanceSquared) continue;
					long distance = (xDist*xDist) + (yDist*yDist) + (zDist*zDist);
					if(distance < (long)distanceSquared){
						pairCounter++;
					}
				}
			}
			System.out.println(pairCounter);

			n = input.nextInt();
		}
	}
}
