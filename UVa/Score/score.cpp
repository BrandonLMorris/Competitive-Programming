#include <iostream>

using namespace std;

int main() {
  int t;
  cin >> t;
  for (int numTest = 0; numTest < t; numTest++) {
    string line;
    cin >> line;
    int counter = 0;
    int x = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.at(i) == 'O') {
        x++;
        counter += x;
      } else {
        x = 0;
      }
    }
    cout << counter << endl;
  }

  return 0;
}
