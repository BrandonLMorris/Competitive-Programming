/**
 * Service Lane
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/24/14.
 */
import java.util.*;

public class ServiceLane {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();           //length of highway
        int n = input.nextInt();                //number of test cases

        int[] highway = new int[length];
        for(int i = 0; i < length; i++){        //input highway values and initialize array
            highway[i] = input.nextInt();
        }

        for(int i = 0; i < n; i++){             //for each test case
            int startPos = input.nextInt();     //input the start and end positions
            int endPos = input.nextInt();

            int maxWidth = 3;                   //counter var too keep up with max possible width for highway section

            for(int j = startPos; j <= endPos; j++){
                if(highway[j] < maxWidth){
                    maxWidth = highway[j];      //if highway is skinnier than current width, adjust current width
                }
            }
            System.out.println(maxWidth);
        }
    }
}
