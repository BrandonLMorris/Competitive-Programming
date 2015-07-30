import java.util.*;

public class Joker {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int d = input.nextInt();
    int songTimeCounter = 0;
    for (int i = 0; i < n; i++) {
      songTimeCounter += input.nextInt();
    }
    if (songTimeCounter + (n-1)*10 > d) {
      System.out.println("-1");
      return;
    }
    int jokes = (n-1)*2;
    jokes += (d - (songTimeCounter + (n-1)*10)) / 5;
    System.out.println(jokes);
  }
}
