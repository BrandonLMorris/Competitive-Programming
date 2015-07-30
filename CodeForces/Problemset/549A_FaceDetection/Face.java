import java.util.*;

public class Face {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int m = Integer.parseInt(input.next());
    int n = Integer.parseInt(input.next());

    if (m < 2 || n < 2) {
      System.out.println(0);
      return;
    }

    char[][] img = new char[m][n];
    for (int i = 0; i < m; i++) {
      String str = input.next();
      for (int j = 0; j < n; j++) {
        img[i][j] = str.charAt(j);
      }
    }

    int faceCounter = 0;
    for (int i = 0; i < m - 1; i++) {
      for (int j = 0; j < n - 1; j++) {
        HashSet<Character> hs = new HashSet<Character>();
        hs.add(img[i][j]);
        hs.add(img[i+1][j]);
        hs.add(img[i][j+1]);
        hs.add(img[i+1][j+1]);
        if (hs.contains('f') && hs.contains('a') &&
            hs.contains('c') && hs.contains('e')) {
              faceCounter++;
            }
      }
    }
    System.out.println(faceCounter);
  }
}
