/*
 * NOTE: This solution times out in Kattis
 */

import java.util.*;
import java.io.*;

public class MST {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (;;) {
      // Read number of vertices and edges
      st = new StringTokenizer(in.readLine());
      int numVerts = Integer.parseInt(st.nextToken());
      int numEdges = Integer.parseInt(st.nextToken());

      if (numVerts == 0 && numEdges == 0) break;

      UnionFind uf = new UnionFind(numVerts);

      Edge[] edges = new Edge[numEdges];

      for (int i = 0; i < numEdges; i++) {
        st = new StringTokenizer(in.readLine());
        edges[i] = new Edge(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }

      Arrays.sort(edges, new WeightComparator());

      int weightCount = 0;
      ArrayList<Edge> spanningTree = new ArrayList<Edge>(numEdges);

      for (int i = 0; i < numEdges && spanningTree.size() < numVerts - 1; i++) {
        Edge e = edges[i];
        if (!uf.sameSet(e.v1, e.v2)) {
          spanningTree.add(e);
          uf.union(e.v1, e.v2);
          weightCount += e.weight;
        }
      }

      if (spanningTree.size() != numVerts - 1) {
        System.out.println("Impossible");
        continue;
      }

      Collections.sort(spanningTree, new LocationComparator());

      System.out.println(weightCount);
      for (Edge e : spanningTree) {
        System.out.println(e.v1 + " " + e.v2);
      }

    }
  }

  private static class UnionFind {
    int[] parent;
    public UnionFind(int initSize) {
      parent = new int[initSize];
      for (int i = 0; i < initSize; i++) parent[i] = i;
    }
    public int find(int x) {
      if (parent[x] == x) return x;
      return parent[x] = find(parent[x]);
    }
    public void union(int x, int y) {
      parent[find(x)] = find(y);
    }
    public boolean sameSet(int x, int y) {
      return find(x) == find(y);
    }
  }

  private static class Edge {
    int v1, v2;
    int weight;
    public Edge(int v1, int v2, int weight) {
      this.v1 = Math.min(v1, v2);
      this.v2 = Math.max(v1, v2);
      this.weight = weight;
    }
  }

  private static class WeightComparator implements Comparator<Edge> {
    public int compare(Edge first, Edge second) {
      return first.weight - second.weight;
    }
  }

  private static class LocationComparator implements Comparator<Edge> {
    public int compare(Edge first, Edge second) {
      if (first.v1 != second.v1) return first.v1 - second.v1;
      if (first.v2 != second.v2) return first.v2 - second.v2;
      return 0;
    }
  }
}