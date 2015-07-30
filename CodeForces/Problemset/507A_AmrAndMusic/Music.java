import java.util.*;

public class Music {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numInstruments = input.nextInt();
    int numDays = input.nextInt();
    Instrument[] list = new Instrument[numInstruments];
    for (int i = 1; i <= numInstruments; i++) {
      list[i-1] = new Instrument(i, input.nextInt());
    }
    Arrays.sort(list);

    int i = 0;
    int counter = 0;
    ArrayList<Instrument> outlist = new ArrayList<Instrument>();
    while (i < list.length && counter + list[i].days <= numDays) {
      outlist.add(list[i]);
      counter += list[i].days;
      i++;
    }

    System.out.println(outlist.size());

    for (int e = 0; e < outlist.size(); e++) {
      System.out.print(outlist.get(e).index);
      if (e != outlist.size()-1)
        System.out.print(" ");
    }
    if (outlist.size() != 0)
      System.out.println();
  }

  private static class Instrument implements Comparable<Instrument> {
    int index;
    int days;
    public Instrument(int indexArg, int daysArg) {
      this.index = indexArg;
      this.days = daysArg;
    }
    public int compareTo(Instrument i) {
      return this.days - i.days;
    }
  }
}

