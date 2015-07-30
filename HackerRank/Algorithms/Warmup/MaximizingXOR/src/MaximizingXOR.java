/**
 * HackerRank:Algorithms:Warmups:Maximizing XOR
 * Created by bmorris on 9/25/14.
 */
import java.util.*;

public class MaximizingXOR {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int l = input.nextInt();
        int r = input.nextInt();

        int max = 0;

        for(int i = l; i <= r; i++){
            for(int j = i; j <= r; j++){
                int xor = i^j;
                if(xor > max) max = xor;
            }
        }
        System.out.println(max);
    }
}
