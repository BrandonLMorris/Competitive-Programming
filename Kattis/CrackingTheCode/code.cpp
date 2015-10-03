#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {
  int num_tests;
  cin >> num_tests;
  for (int t = 0; t < num_tests; t++) {

    int num_encrypted_messages;
    cin >> num_encrypted_messages;
    vector<string> messages(num_encrypted_messages);
    for (int i = 0; i < num_encrypted_messages; i++) {
      cin >> messages[i];
    }
    string decrypted_message;
    cin >> decrypted_message;
    string message_to_decrypt;
    cin >> message_to_decrypt;
    vector<string> decryption_results(num_encrypted_messages);

    for (int i = 0; i < num_encrypted_messages; i++) {
      map<char, char> encrypt_to_decrypt;
      map<char, char> decrypt_to_encrypt;

      if (messages[i].length() != decrypted_message.length()) {
        decryption_results[i] = "\0";
        continue;
      }

      bool invalid = false;
      for (int j = 0; j < messages[i].length(); j++) {
        char e = messages[i].at(j);
        char d = decrypted_message.at(j);
        if (encrypt_to_decrypt.count(e) != 0 && encrypt_to_decrypt[e] != d) {
          invalid = true;
        } else {
          encrypt_to_decrypt[e] = d;
        }
        if (decrypt_to_encrypt.count(d) != 0 && decrypt_to_encrypt[d] != e) {
          invalid = true;
        } else {
          decrypt_to_encrypt[d] = e;
        }
      }


      if (invalid) {
        decryption_results[i] = "\0";
        continue;
      }

      string str = "";
      for (int j = 0; j < message_to_decrypt.length(); j++) {
        if (encrypt_to_decrypt.count(message_to_decrypt[j]) != 0) {
          str += (encrypt_to_decrypt[message_to_decrypt[j]]);
        } else {
          str += '?';
        }
      }

      decryption_results[i] = str;
    }

    string result = "";
    for (int i = 0; i < num_encrypted_messages; i++) {
      if (decryption_results[i].length() != 0) {
        result = decryption_results[i];
        break;
      }
    }

    if (result.length() == 0) {
      cout << "IMPOSSIBLE" << endl;
      continue;
    }

    for (int i = 0; i < num_encrypted_messages; i++) {
      if (decryption_results[i].length() == 0) continue;
      for (int j = 0; j < decryption_results[i].length(); j++) {
        if (result[j] == '?' || decryption_results[i].at(j) == '?') {
          result[j] = '?';
        } else if (result[j] != decryption_results[i].at(j)) {
          result[j] = '?';
        }
      }
    }

    int missing = 0;
    for (int i = 'a'; i <= 'z'; i++) {
      if (result.find(i) == -1) missing++;
    }

    if (missing == 1) {
      for (int i = 'a'; i <= 'z'; i++) {
        if (result.find(i) == -1) {
          result[result.find('?')] = (char)i;
        }
      }
    }

    cout << result << endl;

  }
  return 0;
}
