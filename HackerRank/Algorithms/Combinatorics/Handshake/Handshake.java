import java.util.*;

public class Handshake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int n = input.nextInt();
            System.out.println((n*(n-1))/2);
        }
    }
}
