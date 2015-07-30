/**
 * Halloween Party
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/25/14.
 */
import java.util.*;

public class HalloweenParty {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for(int i = 0; i < t; i++){
            long k = input.nextLong();
            if(k%2 == 0){               //case where k is even
                System.out.println((k/2L)*(k/2L));
            }
            else {
                System.out.println((k/2L)*(k/2L + 1L));
            }
        }
    }
}

/*
2 -> 1      one vert, one hor
3 -> 2      two vert, one hor
4 -> 4      two vert, two hor
5 -> 6      three vert, two hor
6 -> 9      three vert, three hor
7 -> 12     four vert, three hor
8 -> 16     four vert, four hor
 */