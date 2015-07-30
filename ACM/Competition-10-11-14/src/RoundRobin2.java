/**
 * Created by bmorris on 10/11/14.
 */
import java.util.*;

public class RoundRobin2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, t;
        for (;;) {
            int points = 1;
            n = s.nextInt();
            if (n == 0) break;
            t = s.nextInt();
            //int turnsPlayed = 0;
            if (n == t) {
                n--;
                points = 1;
            } else if (n < t) { // if more turns than players
                for (; ; ) { //do rounds of t turns
                    if (t % n == 0) break;
                    points += t / n--;
                }
            } else { // if more players than turns
                boolean hasMoreRounds = true;
                while(hasMoreRounds && n != 2){
                    if(n % t == 0) hasMoreRounds = false;
                    int playersEliminated = n/t;
                    n = n - playersEliminated;
                    points++;
                }
                points--;
            }
            System.out.println(n + " " + points);
        }

    }
}
