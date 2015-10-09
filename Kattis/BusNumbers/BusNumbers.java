import java.util.*;
import java.io.*;

public class BusNumbers {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numBuses = Integer.parseInt(in.readLine());
    int[] buses = new int[numBuses];
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < numBuses; i++) {
      buses[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(buses);
    ArrayList<String> numbers = new ArrayList<String>();
    for (int i = 0; i < numBuses; i++) {
      if (i + 1 < numBuses && i + 2 < numBuses) {
        if (buses[i] == buses[i+1]-1 && buses[i+1] == buses[i+2]-1) {
          int j = i+3;
          while (j < numBuses && buses[j] == buses[j-1]+1) j++;
          numbers.add(buses[i]+"-"+buses[j-1]);
          i = j-1;
          continue;
        }
      }
      numbers.add(Integer.toString(buses[i]));
    }
    StringBuilder sb = new StringBuilder();
    for (String s : numbers) sb.append(s + " ");
    System.out.println(sb.toString().trim());
  }
}