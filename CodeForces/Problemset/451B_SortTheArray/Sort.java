import java.util.*;

/*
 * From an array of distinct integers, find where, if at all, the array can
 * be sorted by reversing exactly one segment of the array.
 */

public class Sort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = a[i];
    }

    // Sort the array
    Arrays.sort(b);

    // Map the unsorted elements to their indices
    HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      hs.put(b[i], i);
    }

    // Set the elements in a to the index of that element in the sorted array 
    for (int i = 0; i < n; i++) {
      a[i] = hs.get(a[i]);
    }

    // Find the inversion from the left
    int leftInversion = -1;
    for (int i = 0; i < n; i++) {
      if (a[i] != i) {
        leftInversion = i;
        break;
      }
    }

    // Find the inversion from the right
    int rightInversion = -1;
    for (int i = n-1; i >= 0; i--) {
      if (a[i] != i) {
        rightInversion = i;
        break;
      }
    }

    // If no inversions, stop here with the answer
    if (leftInversion == rightInversion) {
      System.out.println("yes");
      System.out.println("1 1");
      return;
    }

    // Reverse the elements around the inversion elements, and see if that
    // sorts the array
    reverseArr(a, leftInversion, rightInversion);
    boolean sorted = true;
    for (int i = 0; i < n; i++) {
      if (i != a[i]) {
        sorted = false;
        break;
      }
    }

    // Output the result
    if (sorted){
      System.out.println("yes");
      System.out.println((leftInversion + 1) + " " + (rightInversion + 1));
    } else {
      System.out.println("no");
    }


  }

  // A helper method to reverse the elements in an array at given indices
  public static void reverseArr(int[] array, int start, int end) {
    for (int i = 0; i < (end - start) / 2 + 1; i++) {
      int temp = array[start + i];
      array[start + i] = array[end - i];
      array[end - i] = temp;
    }
  }
}
