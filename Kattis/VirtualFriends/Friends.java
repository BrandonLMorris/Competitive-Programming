import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Friends {
  public static final int MAX_SIZE = 100004;
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {
      int numLines = Integer.parseInt(in.readLine());
      int current = 0;
      UnionFind dset = new UnionFind(MAX_SIZE);
      HashMap<String, Integer> nameId = new HashMap<String, Integer>();

      for (int i = 0; i < numLines; i++) {
        st = new StringTokenizer(in.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        // Map each name to an id if not already
        if (nameId.get(first) == null) {
          nameId.put(first, current);
          current++;
        }
        if (nameId.get(second) == null) {
          nameId.put(second, current);
          current++;
        }

        // Unite the two subsets and print the size
        dset.unite(nameId.get(first), nameId.get(second));
        System.out.println(dset.size[dset.find(nameId.get(second))]);

      }
    }

  }

  /*
   * UnionFind - A simple disjoint set / union find implementation
   * that also keeps track of the size of the subsets
   */
  private static class UnionFind {
    int[] parent;
    int[] size;
    public UnionFind(int n) {
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int find(int x) {
      if (parent[x] == x) {
        return x;
      } else {
        parent[x] = find(parent[x]);
        return parent[x];
      }
    }

    void unite(int x, int y) {
      if (parent[find(x)] != find(y)) {
        size[find(y)] += size[find(x)];
        size[find(x)] = size[find(y)];
      }
      parent[find(x)] = find(y);
    }
  }
}