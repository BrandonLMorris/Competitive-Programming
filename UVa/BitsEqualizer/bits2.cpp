#include <iostream>

using namespace std;

int main() {
  /*
   * Moves count for:
   * 1. Changing a 0 to a 1
   * 2. Changing a ? into a 0 or 1
   * 2. Swapping two positions
   */

  /*
   * Count 1's (and ?'s) in two strings
   * If s1 has too many 1's, output -1
   * Change ?'s to 1's if in correct spot
   * Change any other ?'s to one's or 0's
   * Change any 0's if needed
   * Swap any necessary (diffs/2)
   */

  int numTests;
  cin >> numTests;
  for (int t = 1; t <= numTests; t++) {
    string s1, s2;
    cin >> s1 >> s2;

    //cout << "s1: " << s1 << endl;
    //cout << "s2: " << s2 << endl;

    // If lengths don't match, impossible
    if (s1.length() != s2.length()) {
      cout << "Case " << t << ": " << -1 << endl;
      continue;
    }

    int s1_1counter = 0;
    int s2_1counter = 0;
    int s1_qcounter = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) == '1') s1_1counter++;
      if (s1.at(i) == '?') s1_qcounter++;
      if (s2.at(i) == '1') s2_1counter++;
    }

    // If s1 has too many 1's, impossible
    if (s1_1counter > s2_1counter) {
      cout << "Case " << t << ": -1" << endl;
      continue;
    }

    int result = 0;
    int ones_needed = s2_1counter - s1_1counter;

    // Change ?'s to 1's IF in correct spot
    for (int i = 0; i < s1.length(); i++) {
      if (ones_needed > 0 && s1.at(i) == '?' && s2.at(i) == '1') {
        s1.at(i) = '1';
        result++;
        ones_needed--;
      }
    }

    // Change any 0's to 1's, IF in correct spot
    for (int i = 0; i < s1.length(); i++) {
      if (ones_needed > 0 && s1.at(i) == '0' && s2.at(i) == '1') {
        s1.at(i) = '1';
        ones_needed--;
        result++;
      }
    }

    // Change any remaining ?'s
    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) == '?') {
        result++;
        if (ones_needed > 0) {
          s1.at(i) = '1';
          ones_needed--;
        } else {
          s1.at(i) = '0';
        }
      }
    }

    // Change any 0's to 1's, if necessary
    for (int i = 0; i < s1.length(); i++) {
      if (ones_needed > 0 && s1.at(i) == '0') {
        s1.at(i) = '1';
        result++;
        ones_needed--;
      }
    }

    // Count the diffs
    int diffs = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.at(i) != s2.at(i)) {
        diffs++;
      }
    }

    result += (diffs/2);

    cout << "Case " << t << ": " << result << endl;


  }
  
  return 0;
}
