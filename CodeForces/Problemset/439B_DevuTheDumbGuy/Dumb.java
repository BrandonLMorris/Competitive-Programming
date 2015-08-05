import java.util.*;

/*
 * Given n subjects, each of which has some number of chapters, find the
 * minimum number of hours if a chapter can be learning in x hours. Note that
 * x decreases by one (but never goes below one) for each subject completely
 * learned.
 */

public class Dumb {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of subjects
    int n = in.nextInt();

    // Read the number of hours to learn a chapter (initially)
    int x = in.nextInt();

    // Store the subject chapter quantities in an array
    long[] subjectChapters = new long[n];
    for (int i = 0; i < n; i++) {
      subjectChapters[i] = in.nextLong();
    }

    // Sort the subjects by how many chapters they have
    Arrays.sort(subjectChapters);

    // Now sum up the number of hours needed, decrementing x for every
    // subject completed.
    long total = 0;
    for (int i = 0; i < n; i++) {
      total += Math.max(x-i, 1) * subjectChapters[i];
    }

    System.out.println(total);
  }
}
