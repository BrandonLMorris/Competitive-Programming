/**
 * ACM Candy Store
 * As presented by David Shuckerow 11/5/2014
 */
import java.util.*;

public class CandyStoreDShuck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int n = input.nextInt();
            int m = (int)(input.nextDouble()*100);
            if (n == 0) break;
            int[] caloriesForCosts = new int[m+1];
            for (int i = 0; i < n; i++) {
                int c = input.nextInt();
                int p = (int)(input.nextDouble()*100);
                caloriesForCosts[p] = Math.max(c, caloriesForCosts[p]);
            }

            for (int i = 0; i <= n; i++) {
                for(int j = 0; j <= i/2; j++){
                    int k = i-j;
                    caloriesForCosts[i] = Math.max(caloriesForCosts[j]+caloriesForCosts[k], caloriesForCosts[i]);
                } 
            }
            System.out.println(caloriesForCosts[m]);
        }
    }
}
