/*
 * NOTE: This solution times out on Kattis, however, the C++ equivalent gets AC
 */

import java.util.*;
import java.io.*;

public class Freckles {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      in.readLine();
      int numVerts = Integer.parseInt(in.readLine());
      int currentColor = 0;
      ArrayList<Vertex> vertices = new ArrayList<Vertex>();
      for (int i = 0; i < numVerts; i++) {
        st = new StringTokenizer(in.readLine());
        double d1 = Double.parseDouble(st.nextToken());
        double d2 = Double.parseDouble(st.nextToken());
        vertices.add(new Vertex(d1, d2, currentColor++));
      }

      PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
      for (int i = 0; i < numVerts; i++) {
        for (int j = i+1; j < numVerts; j++) {
          edges.add(new Edge(vertices.get(i), vertices.get(j)));
        }
      }

      UnionFind uf = new UnionFind(numVerts);

      int edgeCount = 0;
      double weightCount = 0;
      while (edgeCount < numVerts-1) {
        Edge current = edges.poll();
        if (!uf.sameSet(current.v1.id, current.v2.id)) {
          weightCount += current.weight;
          uf.union(current.v1.id, current.v2.id);
          edgeCount++;
        }
      }

      System.out.printf("%.2f\n", weightCount);
    }
  }

  // UnionFind class
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

  // Vertex class
  private static class Vertex {
    double x;
    double y;
    int id;
    public Vertex(double x, double y, int id) {
      this.x = x;
      this.y = y;
      this.id = id;
    }
  }

  // Edge class
  private static class Edge implements Comparable<Edge> {
    Vertex v1, v2;
    double weight;
    public Edge(Vertex v1, Vertex v2) {
      this.v1 = v1;
      this.v2 = v2;
      this.weight = Math.hypot((v1.x - v2.x), (v1.y - v2.y));
    }
    public int compareTo(Edge that) {
      if (this.weight == that.weight) return 0;
      if (this.weight > that.weight) return 1;
      return -1;
    }
  }
}
