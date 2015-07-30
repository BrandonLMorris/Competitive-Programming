import java.util.*;

public class Table {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] table = new int[10][10];
    for (int i = 0; i < 10; i++) {
      table[i][0] = 1;
      table[0][i] = 1;
    }
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        table[i][j] = table[i-1][j] + table[i][j-1];
      }
    }

    int num = input.nextInt();
    System.out.println(table[num-1][num-1]);
  }
}
