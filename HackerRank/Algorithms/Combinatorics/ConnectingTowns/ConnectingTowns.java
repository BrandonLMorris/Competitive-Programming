import java.util.*;

public class ConnectingTowns {
    public static final int MOD_NUM = 1234567;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int n = input.nextInt() - 1;
            long counter = input.nextInt();
            for(int i = 0; i < n-1; i++) {
                counter = (counter%MOD_NUM) * (input.nextInt()%MOD_NUM);
            }
            System.out.println(counter%MOD_NUM);
        }
    }
}
