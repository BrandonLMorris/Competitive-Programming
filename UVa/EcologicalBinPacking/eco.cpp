#include <iostream>
#include <limits>

using namespace std;

int main() {

  int b1, g1, c1, b2, g2, c2, b3, g3, c3;

  while (cin >> b1) {
    cin >> g1 >> c1 >> b2 >> g2 >> c2 >> b3 >> g3 >> c3;

    int min = numeric_limits<int>::max();
    int counter, counter2;
    string result;

    // For brown in first bin
    counter = b2 + b3;
    // For clear in second bin
    if (counter + (c1 + c3) + (g1 + g2) < min) {
      min = counter + (c1 + c3) + (g1 + g2);
      result = "BCG";
    }
    // For green in second bin
    if (counter + (g1 + g3) + (c1 + c2) < min) {
      min = counter + (g1 + g3) + (c1 + c2);
      result = "BGC";
    }

    // For clear in first bin
    counter = c2 + c3;
    // For brown in second bin
    counter2 = b1 + b3 + g1 + g2;
    if (counter + counter2 < min) {
      min = counter + counter2;
      result = "CBG";
    }
    // For green in second bin
    counter2 = g1 + g3 + b1 + b2;
    if (counter + counter2 < min) {
      min = counter + counter2;
      result = "CGB";
    }

    // For green in first bin
    counter = g2 + g3;
    // For brown in second bin
    counter2 = b1 + b3 + c1 + c2;
    if (counter + counter2 < min) {
      min = counter + counter2;
      result = "GBC";
    }
    // For clear in second bin
    counter2 = c1 + c3 + b1 + b2;
    if (counter + counter2 < min) {
      min = counter + counter2;
      result = "GCB";
    }

    cout << result << " " << min << endl;


  }

  return 0;
}


/*
 * BCG
 * BGC
 * CBG
 * CGB
 * GBC
 * GCB
 */
