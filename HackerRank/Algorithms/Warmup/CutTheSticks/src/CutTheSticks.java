/**
 * Cut the Sticks
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;

public class CutTheSticks {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        ArrayList<Integer> sticks = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){                 //initializes list with values
            sticks.add(input.nextInt());
        }

        Collections.sort(sticks);                   //Sorts the sticks from smallest to largest
//        System.out.print("The values are: ");
//        for(int i=0; i < sticks.size(); i++) System.out.print(sticks.get(i));

        while(sticks.size() > 0){
            System.out.println(sticks.size());
            for(int i = sticks.size()-1; i >= 0; i--){
                sticks.set(i, sticks.get(i)-sticks.get(0));
                if(sticks.get(i) <= 0) sticks.remove(i);
//                System.out.print("The values are: ");
//                for(int j : sticks) System.out.print(sticks.get(j));
            }
        }

    }
}
