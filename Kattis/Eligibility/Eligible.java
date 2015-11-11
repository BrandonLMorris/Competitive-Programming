import java.util.*;
import java.io.*;

public class Eligible {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      boolean isEligible = false, canPetition = false;
      st = new StringTokenizer(in.readLine());
      String name = st.nextToken();
      String startDate = st.nextToken();
      String birthDate = st.nextToken();
      int courses = Integer.parseInt(st.nextToken());

      boolean first = Integer.parseInt(startDate.substring(0,4)) >= 2010;
      boolean second = Integer.parseInt(birthDate.substring(0,4)) >= 1991;
      boolean third = courses <= 40;

      if (first || second) isEligible = true;
      if (third) canPetition = true;

      if (isEligible) System.out.println(name + " eligible");
      else if (canPetition) System.out.println(name + " coach petitions");
      else System.out.println(name + " ineligible");
    }
  }
}