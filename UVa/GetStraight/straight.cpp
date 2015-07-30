#include <iostream>
using namespace std;

int calculate_hand(int[]);

int main() {

  for (;;) {
    string hand_string[5]; 
    cin >> hand_string[0];
    if (hand_string[0] == "#") break;
    for (int i = 1; i < 5; i++) {
      cin >> hand_string[i];
    }

    // Array to represent deck. 4 of each card,
    // 0 is king, 1 is ace, 11 jack, 12 queen
    int deck[13];
    for (int i = 0; i < 13; i++) {
      deck[i] = 4;
    }
    
    // Array representing the hand
    int hand[13];
    for (int i = 0; i < 13; i++) hand[i] = 0;

    int hand_ints[5];
    for (int i = 0; i < 5; i++) {
      char c = hand_string[i].at(0);
      int num = 0;
      if (c == 'T') num = 10;
      else if (c == 'J') num = 11;
      else if (c == 'Q') num = 12;
      else if (c == 'K') num = 0;
      else if (c == 'A') num = 1;
      else num = c -'0'; 

      hand[num]++;
      deck[num]--;
      hand_ints[i] = num;
    }


    int stay_value = calculate_hand(hand) - 1;

    double probabilities[5];
    for (int i = 0; i < 5; i++) probabilities[i] = -2.0;


    for (int i = 0; i < 5; i++) {
      int v = hand_ints[i];
      int hand_copy[13];
      int deck_copy[13];
      for (int i = 0; i < 13; i++) {
        hand_copy[i] = hand[i];
        deck_copy[i] = deck[i];
      }
      hand_copy[v]--;
      deck_copy[v]++;
      for (int j = 0; j < 13; j++) {
        hand_copy[j]++;
        int winnings = calculate_hand(hand_copy);
        double factor = deck[j] / 47.0;
        probabilities[i] += winnings * factor;
        hand_copy[j]--;
      }
    }


    double result = stay_value;
    int swap_index = -1;
    for (int i = 0; i < 5; i++) {
      if (probabilities[i] > result) {
        result = probabilities[i];
        swap_index = i;
      }
    }

    if (swap_index == -1) {
      cout << "Stay" << endl;
    } else {
      cout << "Exchange " << hand_string[swap_index] << endl;
    }



  }

  return 0;
}

int calculate_hand(int hand[]) {
  // Find the first non-consecutive place to start
  int start_index = 0;
  while (hand[start_index] != 0) start_index++;


  int i = start_index;
  int max_run = 0;
  int run = 0;
  do {
    if (hand[i] != 0) run++;
    else {
      if (run > max_run) max_run = run;
      run = 0;
    }
    i = (i+1)%13;
  } while (i != start_index);
  if (run > max_run) max_run = run;


  // If max run is 0, 1, 4, or 5, return value
  if (max_run == 0 || max_run == 1) return 0;
  if (max_run == 4) return 10;
  if (max_run == 5) return 100;

  // If max run is 2 or 3, check for another run
  if (max_run == 2) {
    int num_two_runs = 0;
    int i = start_index;
    int run = 0;
    do {
      if (hand[i] != 0) run++;
      else {
        if (run == 2) num_two_runs++;
        run = 0;
      }
      i = (i+1)%13;
    } while (i != start_index);
    if (run == 2) num_two_runs++;
    return num_two_runs == 2 ? 1 : 0;
  }

  if (max_run == 3) {
    int i = start_index + 1;
    int run = 0;
    do {
      if (hand[i] != 0) run++;
      else {
        if (run == 2) {
          return 5;
        }
        run = 0;
      }
      i = (i+1)%13;
    } while (i != start_index);
    if (run == 2) return 5;
  }
  // If it gets this far, the only option is a "Menage-a-Trois"
  return 3;
}
