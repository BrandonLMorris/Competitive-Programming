import java.util.*;
import java.io.*;

public class Measure {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String[] units = {"thou", "inch", "foot", "yard", "chain", "furlong",
        "mile", "league"};
    String[] acronym = {"th", "in", "ft", "yd", "ch", "fur", "mi", "lea"};
    int[] factor = {1000, 12, 3, 22, 10, 8, 3};

    st = new StringTokenizer(in.readLine());
    double value = Double.parseDouble(st.nextToken());
    String startUnit = st.nextToken();
    st.nextToken();     // Skip the "in"
    String endUnit = st.nextToken();

    // Find the indexes of the units
    int startUnitIndex = -1, endUnitIndex = -1;
    for (int i = 0; i < units.length; i++) {
      if (units[i].equals(startUnit) || acronym[i].equals(startUnit)) {
        startUnitIndex = i;
      }
      if (units[i].equals(endUnit) || acronym[i].equals(endUnit)) {
        endUnitIndex = i;
      }
    }

    if (startUnitIndex >= endUnitIndex) {
      while (startUnitIndex != endUnitIndex) {
        value *= factor[--startUnitIndex];
      }
    } else {
      while (startUnitIndex != endUnitIndex) {
        value /= factor[startUnitIndex++];
      }
    }

    System.out.println(value);
  }
}
