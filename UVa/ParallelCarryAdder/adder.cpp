#include <iostream>
using namespace std;

string int_arr_to_string(char[]);

int main() {

  int numTests;
  cin >> numTests;
  for (int t = 0; t < numTests; t++) {
    string s1, s2;
    cin >> s1 >> s2;
    int a[31], b[31];
    for (int i = 0; i < 31; i++) {
      a[i] = s1.at(i);
      b[i] = s2.at(i);
    }

    cout << s1 << " " << s2 << endl;


  }

  return 0;
}

string int_arr_to_string(int arr[]) {
  string s = "";
  for (int i = 0; i < 31; i++) {
    s.append(to_string(arr[i]));
  }
  return s;
}

int[] double_binary(int arr[]) {
  string s = int_arr_to_string(arr);
  unsigned long long value = std::bitset<64>(s).to_ullong();
  value *= 2;
  if (value >= pow(2,32) return -1;
  
}
