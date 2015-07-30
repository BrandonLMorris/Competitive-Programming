import java.util.*;

public class DiwaliLights {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int n = input.nextInt();
            int numComb = 2;
            for(int i = 1; i < n; i++){
                numComb *= 2;
                numComb = numComb % 100000;
            }
            numComb--;
            System.out.println(numComb);
        }
    }
}