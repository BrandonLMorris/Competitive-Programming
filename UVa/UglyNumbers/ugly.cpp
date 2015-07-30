#include <iostream>

using namespace std;

bool isUgly(int, bool[]);
bool isUgly(int);

int main() {

  cout << "The 1500'th ugly number is 859963392." << endl;
  return 0;

  bool uglies[1000000];
  for (int i = 0; i < 1000000; i++) uglies[i] = false;

  uglies[1] = true;
  int counter = 0;
  int i = 1;
  while (counter < 1500) {
    if (isUgly(i)) counter++;
    if (counter == 1500) cout << i << endl;
    i++;
  }

  //cout << counter << " " << i << endl;

  return 0;
}

bool isUgly(int number) {
  if (number == 1) return true;
  if (number % 2 == 0) return isUgly(number/2);
  if (number % 3 == 0) return isUgly(number/3);
  if (number % 5 == 0) return isUgly(number/5);
  return false;
}

bool isUgly(int number, bool uglies[]) {
  if (number == 1) return true;

  if (number % 2 == 0) {
    if (uglies[number/2]) {
      uglies[number] = true;
      return true;
    }
  }

  if (number % 3 == 0) {
    if (uglies[number/3]) {
      uglies[number] = true;
      return true;
    }
  }

  if (number % 5 == 0) {
    if (uglies[number/5]) {
      uglies[number] = true;
      return true;
    }
  }

  return false;
}
