#include <iostream>
#include <cmath>

using namespace std;

int main() {
  for (int t = 1;; t++) {
    double x;
    cin >> x;
    if (x < 0) break;

    double y = log(x)/log(2.0);
    int result = (int) ceil(y);

    cout << "Case " << t << ": " << result << endl;

  }

  return 0;
}
