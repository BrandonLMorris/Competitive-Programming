/**
 * Created by bmorris on 10/11/14.
 */

import java.util.*;
import java.lang.*;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, t;
        for (; ; ) {
            n = s.nextInt();
            if (n == 0) break;
            t = s.nextInt();
            int[] players = new int[n];
            for (int i = 0; i < n; i++) {
                players[i] = 0;
            }
            int last = 0;
            int turns = 0;
            for (;;) {
                for (int i = 0; i < t; i++) { //run a round of t turns
                    if (last >= players.length) last = 0;
                    players[last] += 1;
                    last++;
                    if (last == players.length) {
                        last = 0;
                    }
                }
                System.out.println("After " + ++turns + " rounds, ");
                for (int i = 0; i < players.length; i++) {
                    System.out.println("Player " + i + " has " + players[i] + " turns taken");
                }
                if (last == 0) { //game over
                    break;
                }
                for (int i = last; i < players.length - 1; i++) {
                    players[i] = players[i + 1];
                }

                int[] temp = new int[players.length - 1];

                for (int i = 0; i < temp.length; i++) {
                    temp[i] = players[i];
                }
                players = temp; //player is removed
            }
            System.out.println(players.length + " " + players[0]);
        }
    }

}



/*
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, t;
        for (;;) {
            int[] answer = new int[0];
            n = s.nextInt();
            if (n == 0) break;
            t = s.nextInt();
            int turnsPlayed = 0;
            if (n > t) {
                for (; ; ) { //do rounds of t turns
                    if (t % n == 0 || n == 2) break;
                    turnsPlayed += t / n;
                    n--;
                }
            } else {
                answer = recursiveMethod(n, t);
            }
            System.out.println(answer[0] + " " + answer[1]);
        }

    }

    public static int[] recursiveMethod(int n, int t) {
        if (n % t == 0) {
            int[] answer = new int[2];
            answer[0] = n;
            answer[1] = t;
            return answer;
        }
        t = n / t;
        n = n - t;
        return recursiveMethod(n, t);
    }
}
*/