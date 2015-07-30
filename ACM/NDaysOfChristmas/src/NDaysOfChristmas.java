/**
 * The N Days of Christmas
 *
 * Created by bmorris on 10/2/14.
 */
import java.util.*;

public class NDaysOfChristmas {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        while(n!=0){
            System.out.println((n*(n+1)*(n+2))/6);
            n = input.nextInt();
        }
    }
}
