import java.util.*;

public class Matrix {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[][] matrix = new int[5][5];
    int oneRow = -1;
    int oneCol = -1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        matrix[i][j] = input.nextInt();
        if (matrix[i][j] == 1) {
          oneRow = i;
          oneCol = j;
        }
      }
    }
    int counter = Math.abs(2 - oneRow) + Math.abs(2 - oneCol);
    System.out.println(counter);
  }
}
