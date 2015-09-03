import java.util.*;

public class Doorman {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int max = Integer.parseInt(in.nextLine());
    char[] people = in.nextLine().toCharArray();

    int diff = 0;
    for (int i = 0; i < people.length; i++) {

      // If first and second differ in gender, we can make a choice
      if (i < people.length - 2 && people[i] != people[i+1]) {
        // If extra men, take the woman in
        if (diff > 0) {
          diff--;
          people[i+1] = 'M';
        } else {
          // Otherwise take the man in
          diff++;
          people[i+1] = 'W';
        }
      } else {
        if (people[i] == 'M') {
          diff++;
        } else {
          diff--;
        }
      }

      // Check if the difference has grown too much
      if (Math.abs(diff) > max) {
        System.out.println(i);
        return;
      }
    }

    // Whole line was let in
    System.out.println(people.length);
  }
}
