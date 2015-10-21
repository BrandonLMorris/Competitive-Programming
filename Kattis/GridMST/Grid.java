import java.util.*;
import java.io.*;

public class Grid {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numVertices = Integer.parseInt(in.readLine());
    Vertex[] vertices = new Vertex[numVertices];
    for (int i = 0; i < numVertices; i++) {
      st = new StringTokenizer(in.readLine());
      vertices[i] = new Vertex(Integer.parseInt(st.nextToken()),
        Integer.parseInt(st.nextToken()), i);
    }

    PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
    for (int i = 0; i < numVertices; i++) {
      for (int j = i+1; j < numVertices; j++) {
        edges.add(new Edge(vertices[i], vertices[j]));
      }
    }

    DisjointSet ds = new DisjointSet();

    int edgeCount = 0;
    long weightCount = 0;
    while (edgeCount < numVertices-1) {
      Edge current = edges.poll();
      if (ds.sameSet(current.v1.id, current.v2.id)) continue;
      weightCount += current.distance;
      ds.union(current.v1.id, current.v2.id);
      edgeCount++;
    }

    System.out.println(weightCount);

  }

  private static class Vertex {
    int x, y, id;
    public Vertex(int x, int y, int id) {
      this.x = x;
      this.y = y;
      this.id = id;
    }
  }

  private static class Edge implements Comparable<Edge> {
    Vertex v1, v2;
    long distance;
    public Edge(Vertex v1, Vertex v2) {
      this.v1 = v1;
      this.v2 = v2;
      this.distance = Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }
    public int compareTo(Edge that) {
      if (this.distance == that.distance) return 0;
      if (this.distance > that.distance) return 1;
      return -1;
    }
  }

  private static class DisjointSet {
    int[] parent;
    public DisjointSet() {
      this.parent = new int[100000];
      for (int i = 0; i < 100000; i++) parent[i] = i;
    }
    public int find(int x) {
      if (parent[x] == x) return x;
      return parent[x] = find(parent[x]);
    }
    public void union(int x, int y) {
      parent[find(x)] = parent[y];
    }
    public boolean sameSet(int x, int y) {
      return find(x) == find(y);
    }
  }
}