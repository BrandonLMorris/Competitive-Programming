import java.util.*;

/*
 * Given a list of exams with dates a and b, find the minimum last day such
 * that the order of a days is nondecreasing.
 */

public class Exams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of exams
    int n = in.nextInt();

    // Read in each exam
    Exam[] exams = new Exam[n];
    for (int i = 0; i < n; i++) {
      exams[i] = new Exam(in.nextInt(), in.nextInt());
    }

    // Sort the exams (based on a first, then b)
    Arrays.sort(exams);

    // We know that a's are nondecreasing, but using b will always be better
    // (if possible). Iterate through the exams, using b when possible and
    // falling back to a.
    int best = -1;
    for (int i = 0; i < n; i++) {
      if (best <= exams[i].b) {
        best = exams[i].b;
      } else {
        best = exams[i].a;
      }
    }

    System.out.println(best);

  }

  // Private class to hold the exam and make sorting easy
  private static class Exam implements Comparable<Exam> {
    int a;
    int b;

    public Exam(int a_arg, int b_arg) {
      this.a = a_arg;
      this.b = b_arg;
    }

    public int compareTo(Exam that) {
      if (this.a < that.a) {
        return -1;
      } else if (this.a > that.a) {
        return 1;
      } else {
        return this.b - that.b;
      }
    }
  }
}
