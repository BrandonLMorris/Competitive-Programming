import java.util.*;
import java.io.*;

public class Torn {
  public static void main(String[] args) throws Exception {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int numLines = Integer.parseInt(in.readLine());
      HashMap<String, Node> nameToNode = new HashMap<String, Node>();

      for (int i = 0; i < numLines; i++) {
        st = new StringTokenizer(in.readLine());
        ArrayList<String> locations = new ArrayList<String>();
        while (st.hasMoreTokens()) {
          locations.add(st.nextToken());
        }
        if (nameToNode.get(locations.get(0)) == null) {
          nameToNode.put(locations.get(0), new Node(locations.get(0)));
        }

        Node start = nameToNode.get(locations.get(0));
        for (int j = 1; j < locations.size(); j++) {
          if (nameToNode.get(locations.get(j)) == null) {
            nameToNode.put(locations.get(j), new Node(locations.get(j)));
          }
          Node current = nameToNode.get(locations.get(j));
          start.neighbors.add(current);
          current.neighbors.add(start);
        }
      }

      st = new StringTokenizer(in.readLine());
      String start = st.nextToken();
      String end = st.nextToken();
      if (nameToNode.get(start) == null || nameToNode.get(end) == null) {
        System.out.println("no route found");
        return;
      }
      ArrayList<String> path = new ArrayList<String>();
      path.add(start);
      if (findRoute(nameToNode.get(start), nameToNode.get(end), path)) {
      StringBuilder sb = new StringBuilder();
      for (String s : path) {
        sb.append(s + " ");
      }
      System.out.println(sb.toString().trim());
    } else {
      System.out.println("no route found");
    }
  }

  // Use DFS to find a viable route (at most one)
  private static boolean findRoute(Node current, Node goal, ArrayList<String> path) {
    if (current.name == goal.name) {
      return true;
    }
    for (Node n : current.neighbors) {
      if (!path.contains(n.name)) {
        path.add(n.name);
        if (findRoute(n, goal, path)) {
          return true;
        }
        path.remove(n.name);
      }
    }
    return false;
  }

  private static class Node {
    String name;
    int color;
    ArrayList<Node> neighbors;
    public Node(String name) {
      this.name = name;
      neighbors = new ArrayList<Node>();
    }
  }
}