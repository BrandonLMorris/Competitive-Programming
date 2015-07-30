//Created 9/21
//Original solution by Brian DeLoach

import java.util.*;

public class CandyStoreSolution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for(;;){
			int items = in.nextInt();
			int money = (int)(in.nextDouble() * 100);

			if(items == 0) break;

			int calories[] = new int[items];
			int price[] = new int[items];

			for(int i = 0; i < items; i++){
				calories[i] = in.nextInt();
				price[i] = (int)(in.nextDouble() *100);
			}

			int[] total = new int[money+1];
			int max = 0;

			for(int i = 0; i < money; i++){
				if(total[i] > 0 || i == 0){
					for(int item = 0; item < items; item++){
						int cost = i + price[item];
						if(cost > money) continue;

						int addCal = total[i] + calories[item];
						int curCal = total[cost];

						if(addCal > curCal) {
							total[cost] = addCal;

							if(total[cost] > max){
								max = total[cost];
							}
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
