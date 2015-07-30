import java.util.Scanner;

public class Islands {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numTests = input.nextInt();
    for(int t = 1; t <= numTests; t++) {
      // Passes over test number
      input.nextInt();
      int numIslands = 0;

      // Read in data stream to int array
      int[] dataStream = new int[15];
      for (int i = 0; i < 15; i++) {
        dataStream[i] = input.nextInt();
      }

      // From 0 to 8, find all islands with i surrounding it
      for (int i = 0; i < 9; i++) {
        // first index of i value in data stream
        int first = 0;
        // Move first through the array until reaches end or encoutners value
        while (first < dataStream.length && dataStream[first] != i) first++;
        // Continue if value not found or at end of array (where no island possible)
        if (first >= dataStream.length || dataStream[first] != i) continue;

        // second: index of second occurance of i in the data stream
        int second = first+1;
        while (second < dataStream.length && dataStream[second] != i) second++;
        if (second >= dataStream.length || dataStream[second] != i) continue;

        while (second < dataStream.length && dataStream[second] == i) {
          //System.out.println("Help, I'm stuck");
          // See if first to second is an island
          boolean isIsland = true;
          // If first and second are adjacent, not an island
          if (first + 1 == second) isIsland = false;
          for (int j = first+1; j < second; j++) {
            if (dataStream[j] < dataStream[first])
              isIsland = false;
          }
          if (isIsland) numIslands++;

          first = second;
          second++;

          if (second == dataStream.length - 1) second = 40;
          while (second < dataStream.length && dataStream[second] != i) second++;
          //if (dataStream[second] != i) second++;
          //System.out.println("first = " + first + " second = " + second);
        }
      }

      System.out.println(t + " " + numIslands);

    }
  }
}
