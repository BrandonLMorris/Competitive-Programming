/**
 * Chocolate Feast
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;

public class ChocolateFeast {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();            //n is the amount of money Little Bob has
            int c = input.nextInt();            //c is the cost per candy bar
            int m = input.nextInt();            //m is the number of wrappers to get another candy bar

            int candyBars = n/c;                //Little Bob spends all his money on candy
            int wrappers = candyBars;           //for every candy bar he has one wrapper
            while(wrappers >= m){                //he will keep spending wrappers on bars so long as he can
                int temp = wrappers/m;          //number of bars he can buy with his wrappers
                candyBars += temp;              //add the number of bars that Bob bought
                wrappers = wrappers % m;        //he now only has the bars he couldnt spend
                wrappers += temp;               //plus the ones he just bought
            }

            System.out.println(candyBars);
        }
    }
}
