import java.util.*;

public class MinDraws {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int socksInDrawer = input.nextInt();
            System.out.println(socksInDrawer+1);
        }
    }
}
