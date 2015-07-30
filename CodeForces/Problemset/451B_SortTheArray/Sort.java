import java.util.*;

public class Sort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    boolean foundDecreasing = false;
    boolean decreasingFinished = false;
    boolean isYes = false;

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    boolean isAllDecreasing = true;
    for (int i = 0; i < n-1; i++) {
      if (arr[i] < arr[i+1]) {
        isAllDecreasing = false;
        break;
      }
    }
    isYes = isAllDecreasing;

    int startIndex = 0;
    int endIndex = 0;
    for (int i = 0; i < n-1; i++) {
      if (arr[i] > arr[i+1]) {
        if (foundDecreasing && !decreasingFinished) {
          continue;
        } else if (foundDecreasing && decreasingFinished) {
          isYes = false;
          break;
        } else {
          foundDecreasing = true;
          startIndex = i;
        }
      } else if (arr[i] < arr[i+1] && foundDecreasing && !decreasingFinished) {
        decreasingFinished = true;
        isYes = true;
        endIndex = i;
      }
    }

    System.out.println(isYes ? "yes" : "no"); 
    if (isAllDecreasing) {
      startIndex = 1;
      endIndex = n;
    } else {
      startIndex++;
      endIndex++;
    }
    if (isYes) {
      System.out.println(startIndex + " " + endIndex);
    }

  }
}


/*
 * [X] Increase only
 * Increase, decrease
 * Increase, decrease, increase
 * Decrease, increase
 * Decrease
 *
 * must be *exactly* one point at which the array decreases
 * mark the beginning an dthe end of the decreasing section
 */
