import java.util.*;
import java.io.*;

public class ACM {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(in.readLine());
    int numProbs = Integer.parseInt(st.nextToken());
    int firstIndex = Integer.parseInt(st.nextToken());

    // Read problem times, convert to integers
    int[] probs = new int[numProbs];
    String[] probsStr = in.readLine().split(" ");
    for (int i = 0; i < numProbs; i++) {
      probs[i] = Integer.parseInt(probsStr[i]);
    }

    int counter = 0, currentTime = 0, penaltyTime = 0;

    // Only if the first problem can be solved in the time limit
    if (probs[firstIndex] <= 300) {
      // Add the first problem, then remove it from further consideration
      currentTime = penaltyTime += probs[firstIndex];
      counter++;
      probs[firstIndex] = Integer.MAX_VALUE;
      Arrays.sort(probs);

      int pos = 0;
      while (pos < numProbs-1 && currentTime + probs[pos] <= 300) {
        currentTime += probs[pos];
        counter++;
        penaltyTime += currentTime;
        pos++;
      }
    }

    System.out.println(counter + " " + penaltyTime);
  }
}
