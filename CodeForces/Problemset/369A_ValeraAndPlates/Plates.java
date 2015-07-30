import java.util.*;

public class Plates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int numBowls = input.nextInt();
        int numPlates = input.nextInt();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int j = input.nextInt();
            if (j == 1) {
                if (numBowls == 0) {
                    counter++;
                } else {
                    numBowls--;
                }
            } else {
                if (numPlates != 0) {
                    numPlates--;
                } else if (numBowls != 0) {
                    numBowls--;
                } else {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
