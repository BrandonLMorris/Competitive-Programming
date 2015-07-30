import java.util.*;

public class Mad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int seqLen = input.nextInt();
            if(seqLen == 0) break;
            int[] sequence = new int[seqLen];
            for(int i = 0; i < seqLen; i++) {
                sequence[i] = input.nextInt();
            }

            ArrayList<Integer> experiment = new ArrayList<Integer>(seqLen);
            int current = 0;
            for(int i = 1; i <= seqLen; i++) {
                int numAdd = sequence[i-1] - current;
                for(int j = 0; j < numAdd; j++) {
                    experiment.add(i);
                    current++;
                }
            }

            for(Integer i : experiment) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
