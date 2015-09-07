import java.util.*;

public class Loop {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int numTests = Integer.parseInt(in.nextLine());
    for (int t = 0; t < numTests; t++) {
      int n = Integer.parseInt(in.nextLine());
      PriorityQueue<Integer> redList =
        new PriorityQueue<Integer>(10, Collections.reverseOrder());
      PriorityQueue<Integer> blueList =
        new PriorityQueue<Integer>(10, Collections.reverseOrder());

      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      while(lineScanner.hasNext()) {
        String temp = lineScanner.next();
        if (temp.charAt(temp.length()-1) == 'R') {
          redList.add(Integer.parseInt(temp.substring(0, temp.length()-1)));
        } else {
          blueList.add(Integer.parseInt(temp.substring(0, temp.length()-1)));
        }
      }

      int knotCount = Math.min(redList.size(), blueList.size());
      int lengthCount = 0;
      for (int i = 0; i < knotCount; i++) {
        int r = redList.poll();
        lengthCount += r;

        int b = blueList.poll();
        lengthCount += b;

        // System.out.println("Adding " + r +  " red and " + b + " blue");
      }

      if (lengthCount > 0) lengthCount -= (knotCount * 2);
      System.out.println("Case #" + (t+1) + ": " + lengthCount);


    }
  }
}
