import java.util.*;

public class Exam {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());
    HashSet<String> profList = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      profList.add(in.nextLine());
    }

    n = Integer.parseInt(in.nextLine());
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (profList.contains(in.nextLine()))
        counter++;
    }

    System.out.println(counter);

  }
}
