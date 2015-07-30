#include <iostream>

int main() {
  int a, b, c, d;
  
  for (;;) {

    std::cin >> a >> b >> c >> d;
    if (a == 0) break;

    int counter = 0;

    while (a != 0 || b != 0 || c || 0 || d != 0) {

      int a2 = a;

      a = std::abs(a-b);
      b = std::abs(b-c);
      c = std::abs(c-d);
      d = std::abs(d-a2);

      //std::cout << a << " " << b << " " << c << " " << d << std::endl;

      counter++;
    }

    std::cout << counter-1 << std::endl;

  }

  return 0;
}
