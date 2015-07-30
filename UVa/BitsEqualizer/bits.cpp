#include <iostream>

using namespace std;

int main() {

  /*
   *  0's can change to 1's (1's CANNOT change to 0's)
   *  ?'s can change to 0's or 1's
   *  Any two numbers can be swapped
   */

  int numTests;
  cin >> numTests;
  for (int t = 1; t <= numTests; t++) {
    string s1, s2;
    cin >> s1 >> s2;

    // Impossible if lengths don't match
    if (s1.length() != s2.length()) {
      cout << "Case " << t << ": " << -1 << endl;
      continue;
    }

    int s1OneCounter, s2OneCounter, s1QCounter;
    // Count 1's and ?'s in s1
    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) == '1') s1OneCounter++;
      if (s1.at(i) == '?') s1QCounter++;
    }
    // Count 1's in s2
    for (int i = 0; i < s2.length(); i++) {
      if (s2.at(i) == '1') s2OneCounter++;
    }

    // Impossible if s1 has too many ones (1's can't change to 0's)
    if (s1OneCounter > s2OneCounter) {
      cout << "Case " << t << ": " << -1 << endl;
      continue;
    }

    int result = s1QCounter;

    int onesNeeded = s2OneCounter - s1OneCounter;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) == '?' && s2.at(i) == '1') {
        s1.at(i) = '1';
        s1QCounter--;
        s1OneCounter++;
        onesNeeded--;
      }
    }

    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) == '?') {
        if (onesNeeded > 0) {
          s1.at(i) = '1';
          onesNeeded--;
          s1OneCounter++;
          s1QCounter--;
        } else {
          s1.at(i) = '0';
          s1QCounter--;
        }
      }
    }

    for (int i = 0; i < s1.length(); i++) {
      if (onesNeeded > 0) {
        if (s1.at(i) == '0' && s2.at(i) == '1') {
          s1.at(i) = '1';
          s1OneCounter++;
          onesNeeded--;
          result++;
        }
      }
    }

    int diffs = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) != s2.at(i)) diffs++;
    }

    result += (diffs/2);

    cout << "Case " << t << ": " << result << endl;

  }
}
