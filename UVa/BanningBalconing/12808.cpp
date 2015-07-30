#include <iostream>
#include <cmath>
using namespace std;

const double A = 9.81;

int main() {

  int numTests;
  cin >> numTests;
  for (int t = 0; t < numTests; t++) {
    double L, D, H, V;
    cin >> L >> D >> H >> V;

    // Convert units from millimeters to meters
    L /= 1000;
    D /= 1000;
    H /= 1000;
    V /= 1000;


    double horizontal_distance = V * sqrt((2*H)/A);


    if (horizontal_distance < D - 0.5) {
      cout << "FLOOR" << endl;
    } else if (horizontal_distance >= D - 0.5 &&
               horizontal_distance <= D + 0.5) {
      cout << "EDGE" << endl;
    } else if (horizontal_distance > D + 0.5 &&
               horizontal_distance < D + L - 0.5) {
      cout << "POOL" << endl;
    } else if (horizontal_distance >= D + L - 0.5 &&
               horizontal_distance <= D + L + 0.5) {
      cout << "EDGE" << endl;
    } else {
      cout << "FLOOR" << endl;
    }

  }

  return 0;
}
