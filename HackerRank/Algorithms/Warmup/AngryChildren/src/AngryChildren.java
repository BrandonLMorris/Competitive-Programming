/**
 * Angry Children
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;

public class AngryChildren {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        int[] packets = new int[n];

        for(int i = 0; i < n; i++){         //initialize the packets of candy
            packets[i] = input.nextInt();
        }

        Arrays.sort(packets);               //puts the packets in ascending order
        int minUnfairness = packets[n-1] - packets[0];  //set the unfairnes counter to max possible
        for(int i = 0; i<=packets.length - k; i++){
            int temp = packets[i+k-1] - packets[i];
            if(temp<minUnfairness) minUnfairness = temp;
        }
        System.out.println(minUnfairness);
    }
}
