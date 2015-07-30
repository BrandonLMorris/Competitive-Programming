/**
 * Mark and Toys
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/3/2014
 */
import java.util.*;

public class MarkAndToys {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numToys = input.nextInt();
        int money = input.nextInt();

        //set up ArrayList to store toys
       ArrayList<Integer> toys = new ArrayList<Integer>(numToys); 

        for(int i = 0; i < numToys; i++) {
            toys.add(input.nextInt());
        }

        //Collections.sort() to sort toys
        Collections.sort(toys);

        int priceCounter = 0;
        int toyCounter = 0;
        for(int i = 0; toys.get(i) + priceCounter < money; i++) {
           toyCounter++; 
           priceCounter += toys.get(i);
        }

        System.out.println(toyCounter);
    }
}
