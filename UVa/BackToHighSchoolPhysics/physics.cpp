#include <iostream>
#include <cmath>

int main() {

  int v, t;
  while (std::cin >> v >> t) {
    if (v == 0 || t == 0) {
      std::cout << 0 << std::endl;
      continue;
    }

    double acc = (double)v / (double)t;
    int newTime = t * 2;

    double dist = (0.5) * (acc) * std::pow(newTime, 2);
    std::cout << (int)std::round(dist) << std::endl;
  }

  return 0;
}
