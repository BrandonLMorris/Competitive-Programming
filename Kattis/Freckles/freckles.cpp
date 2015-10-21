#include <math.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Vertex {
 public:
  double x, y;
  int id;
  Vertex(double _x, double _y, int _id) {
    x = _x;
    y = _y;
    id = _id;
  }
};


class Edge {
 public:
  Vertex *v1, *v2;
  double weight;
  Edge(Vertex &_v1, Vertex &_v2) {
    v1 = &_v1;
    v2 = &_v2;
    weight = hypot(v1->x-v2->x, v1->y-v2->y);
  }
  bool operator < (const Edge& that) const {
    return weight < that.weight;
  }
};


class UnionFind {
 public:
  vector<int> parent;
  UnionFind(int initSize) {
    parent = vector<int>(initSize);
    for (int i = 0; i < initSize; i++) parent[i] = i;
  }
  int find(int x) {
    if (parent[x] == x) return x;
    parent[x] = find(parent[x]);
    return parent[x];
  }
  void ds_union(int x, int y) {
    parent[find(x)] = parent[y];
  }
  bool same_set(int x, int y) {
    return (find(x) == find(y));
  }
};

int main() {
  int num_tests;
  cin >> num_tests;

  for (int t = 0; t < num_tests; t++) {
    int num_verts;
    cin >> num_verts;
    int current_id = 0;
    vector<Vertex> vertices;
    for (int i = 0; i < num_verts; i++) {
      double x, y;
      cin >> x >> y;
      vertices.push_back(Vertex(x, y, current_id++));
    }


    vector<Edge> edges;
    for (int i = 0; i < num_verts; i++) {
      for (int j = i+1; j < num_verts; j++) {
        edges.push_back(Edge(vertices.at(i), vertices.at(j)));
      }
    }

    UnionFind dset(1004);
    sort(edges.begin(), edges.end());

    int edge_count = 0;
    int pos = 0;
    double weight_count = 0.0;
    while (edge_count < num_verts-1) {
      if (!dset.same_set(edges.at(pos).v1->id, edges.at(pos).v2->id)) {
        weight_count += edges.at(pos).weight;
        dset.ds_union(edges.at(pos).v1->id, edges.at(pos).v2->id);
        edge_count++;
      }
      pos++;
    }

    printf("%.2f\n", weight_count);
  }
}