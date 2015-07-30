//19
//ACM Candy Store
//Created by Brandon Morris 10/7/2014

import java.util.*;

public class CandyStore{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n != 0){
			int[] money = new int[(int)(input.nextDouble()*100 + 1)];
			int[] calories = new int[n];
			int[] prices = new int[n];

			for(int i = 0; i < n; i++){
				calories[i] = input.nextInt();
				prices[i] = (int)(input.nextDouble()*100);
			}

			int maxCal = 0;
			for(int i = 0; i < money.length; i++){
				if(money[i] > 0 || i == 0){
					for(int j = 0; j < n; j++){
						int cost = i + prices[j];
						if(cost > money.length) continue;
						int totCalories = calories[j] + money[i];
						if(totCalories > money[cost]){
							money[cost] = totCalories;
						}
						if(money[cost] > maxCal) maxCal = money[cost];
					}
				}
			}
			System.out.println(maxCal);

			n = input.nextInt();
		}
	}
}
