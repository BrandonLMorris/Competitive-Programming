/*66
 *ACM 2008 Problem: Combination Lock
 *Created by Brandon Morris 10/6/2014
*/
import java.util.*;

public class CombinationLock{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n != 0){
			int t1 = input.nextInt();
			int t2 = input.nextInt();
			int t3 = input.nextInt();

			int maxTicks = 0;

			for(int i = 0; i < n; i++){
				int ticks = 0;
				int pos = i;
				if(pos == t1) continue;
	
				ticks += n*2;			//first two full rotations

				//Moving to t1 (clockwise, numbers descending)
				if(t1 < pos){
					ticks += pos-t1;			//continue turning until t1. Pos at t1
					pos = t1;
				}
				else{
					ticks += pos;
					ticks += n - t1;
					pos = t1;
				}

				ticks += n;			//one full rotation counterclockwise

				//Moving to t2 (counterclockwise, numbers ascending)
				if(t2 > pos){
					ticks += t2-pos;
					pos = t2;
				}
				else{
					ticks += n-pos;
					ticks += t2;
					pos = t2;
				}

				//Moving to t3 (clockwise, numbers descending)
				if(t3 < pos){
					ticks += pos-t3;
					pos = t3;
				}
				else{
					ticks += pos;
					ticks += n-t3;
				}
				//System.out.println("Starting pos " + i + ": " + ticks);

				if(ticks > maxTicks || maxTicks == 0) maxTicks = ticks;
			}
			System.out.println(maxTicks);

			n = input.nextInt();
		}
	}
}
