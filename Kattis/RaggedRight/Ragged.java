import java.util.*;

public class Ragged {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    ArrayList<String> lines = new ArrayList<String>();
    int maxLen = 0;
    while (in.hasNext()) {
      String line = in.nextLine();
      maxLen = Math.max(maxLen, line.length());
      lines.add(line);
    }

    int counter = 0;
    for (int i = 0; i < lines.size() - 1; i++) {
      counter += Math.pow(maxLen - lines.get(i).length(), 2);
    }

    System.out.println(counter);
  }
}
