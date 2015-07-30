import java.util.*;

public class Frugal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      ArrayList<String> dict = new ArrayList<String>();
      String line = input.nextLine();
      if (line.trim().equals("#")) break;
      while (!line.equals("*")) {
        dict.add(line);
        line = input.nextLine();
      }

      Collections.sort(dict);

      String query = input.nextLine();
      while (!query.equals("**")) {
        ArrayList<Query> queries = new ArrayList<Query>();
        Query q = new Query();
        for (int i = 0; i < query.length(); i++) {
          if (query.charAt(i) == '|') {
            queries.add(q);
            q = new Query();
          } else if (query.charAt(i) == '+') {
            i++;
            q.positive.add(query.charAt(i));
          } else if (query.charAt(i) == '-') {
            i++;
            q.negative.add(query.charAt(i));
          } else {
            q.not_signed.add(query.charAt(i));
          }
        }
        queries.add(q);
        //System.out.println("Queries: ");
        //for (Query qu : queries) {
        //    System.out.println(qu);
        //}

        String[] matches = new String[queries.size()];
        for (int i = 0; i < matches.length; i++) {
          matches[i] = match(dict, queries.get(i));
        }

        String lowest = null;
        for (int i = 0; i < matches.length; i++) {
          if (matches[i] != null && (lowest == null || matches[i].compareTo(lowest) < 0)) {
            lowest = matches[i];
          }
        }

        if (lowest == null) {
          System.out.println("NONE");
        } else {
          System.out.println(lowest);
        }

        query = input.nextLine();
      }
      System.out.println("$");
    }
  }

  static String match(ArrayList<String> dict, Query q) {
    for (String word : dict) {
      for (char c : q.not_signed) {
        if (word.contains(""+c)) {
          boolean isMatch = true;
          for (char d : q.positive) {
            if (!word.contains(""+d)) {
              isMatch = false;
              break;
            }
          }
          for (char d : q.negative) {
            if (word.contains(""+d)) {
              isMatch = false;
              break;
            }
          }
          if (isMatch)
            return word;
        }
      }
    }
    return null;
  }
}

class Query {
  ArrayList<Character> not_signed;
  ArrayList<Character> positive;
  ArrayList<Character> negative;
  public Query() {
    not_signed = new ArrayList<Character>();
    positive = new ArrayList<Character>();
    negative = new ArrayList<Character>();
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Not signed: ");
    for (char c : not_signed) {
        sb.append(c);
    }
    sb.append("\nPositive: ");
    for (char c : positive) {
        sb.append(c);
    }
    sb.append("\nNegative: ");
    for (char c : negative) {
        sb.append(c);
    }
    return sb.toString();
  }
}
