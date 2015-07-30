import math

while(True):
  a, b, c, d = [int(e) for e in raw_input().split()]
  if (a == b == c == d == 0): break
  counter = 0
  while (a != b or b != c or c != d):
    a1, b1, c1, d1 = a, b, c, d
    a = abs(a1-b1)
    b = abs(b1-c1)
    c = abs(c1-d1)
    d = abs(d1-a1)
    #print(str(a) + " " + str(b) + " "+str(c)+" "+str(d))
    counter += 1
  
  print counter
