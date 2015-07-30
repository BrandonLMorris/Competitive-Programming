/**
 * Multiples of 3 and Five
 * HackerRank :: Project Euler Contest
 * Created by Brandon Morris 11/7/2014
 */
import java.util.*;

public class MultiplesOf3And5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int end = input.nextInt();
            int counter = 0;
            for(int i = 0; i < end; i++) {
                if((i % 3) == 0 || (i % 5) == 0) {
                    counter += i;
                }
            }
            System.out.println(counter);
        }
    }
}
