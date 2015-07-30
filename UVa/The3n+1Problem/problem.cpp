#include <iostream>

using namespace std;

int main() {
  //int lengths[1000001];
  //lengths[1] = 1;
  //lengths[2] = 2;
  int x;
  int y;

  while(cin >> x && cin >> y) {

    int min = x < y ? x : y;
    int max = x < y ? y : x;

    int results[max-min+1];

    int result = 0;
    int k = 0;
    for (int i = min; i <= max; i++) {
      int counter = 1;
      int j = i;

      while (j != 1) {
        //if (j < 1000000 && lengths[j] != 0) {
        //  counter += lengths[j];
        //  break;
        //}
        if (j % 2 == 0) j /= 2;
        else j = j*3 + 1;
        ++counter;
      }

      //lengths[i] = counter;
      results[k] = counter;
      k++;

    }


    for (int i = 0; i <= max-min; i++) {
      if (results[i] > result)
        result = results[i];
    }

    cout << x << " " << y << " " << result << endl;
  }

  return 0;
}
