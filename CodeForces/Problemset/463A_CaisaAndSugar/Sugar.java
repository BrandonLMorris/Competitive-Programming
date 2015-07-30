import java.util.*;

public class Sugar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int s = input.nextInt();
        int maxCandies = -1;
        for (int i = 0; i < n; i++) {
            int dollars = input.nextInt();
            int cents = input.nextInt();
            if (dollars < s || (dollars == s && cents == 0)) {
                int candies = cents == 0 ? 0 : 100 - cents;
                maxCandies = Math.max(maxCandies, candies);
            }
        }
        System.out.println(maxCandies);
    }
}
