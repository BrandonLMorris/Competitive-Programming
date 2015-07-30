/**
 * The Perfect Shuffle
 * ACM ICPC 2013: H
 * Created by bmorris on 9/18/14.
 *
 */

import java.util.*;

public class PerfectShuffle {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int deckSize = input.nextInt();

        while(deckSize != 0) {
            input.nextLine();
            String[] deck = new String[deckSize];
            for (int i = 0; i < deckSize; i++) {
                deck[i] = input.nextLine();
            }
            if(deckSize % 2 == 0){  //the deck has an even number of cards
                for(int i = 0; i < deckSize/2; i++){
                    System.out.println(deck[i]);
                    System.out.println(deck[i+(deckSize/2)]);
                }
            } else {
                for(int i = 0; i < deckSize/2; i++){
                    System.out.println(deck[i]);
                    System.out.println(deck[i+(deckSize/2)+1]);
                }
                System.out.println(deck[deckSize/2]);
            }

            deckSize = input.nextInt();
        }
    }

}
