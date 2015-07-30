#include <iostream>

using namespace std;

int main() {

  long long x, y;
  while (cin >> x >> y) {
    long long min, max;
    min = x < y ? x : y;
    max = x < y ? y : x;

    cout << max - min << endl;
  }

  return 0;
}
