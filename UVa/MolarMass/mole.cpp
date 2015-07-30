#include <iostream>
#include <sstream>
using namespace std;

int main() {
  const double CARBON = 12.01;
  const double HYDROGEN = 1.008;
  const double OXYGEN = 16.00;
  const double NITROGEN = 14.01;

  int numTests;
  cin >> numTests;

  for (int t = 0; t < numTests; t++) {
    string formula;
    cin >> formula;
    stringstream stream(formula);
    double result = 0.0;
    while (!stream.eof() && stream.good()) {
      char element;
      int factor;
      stream >> element;
      if (!stream.eof() && stream.peek() > '0' && stream.peek() <= '9') {
        stream >> factor;
      } else factor = 1;
      double grams;
      switch (element) {
        case 'C': grams = CARBON; break;
        case 'H': grams = HYDROGEN; break;
        case 'O': grams = OXYGEN; break;
        case 'N': grams = NITROGEN; break;
        default:
                  grams = 0.0;
                  break;
      }
      result += grams * factor;
    }

    printf("%.3lf\n", result);
  }
}
