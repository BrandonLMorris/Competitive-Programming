from fractions import gcd

def lcm(a, b):
    return a * b // gcd(a,b)

while (True):
    M, N = [float(e) for e in raw_input().split()]
    if (M == N == 0): break

    denominators = []

    counter = float(M) / N
    cM = M
    cN = N
    i = 1
    while (i < 1000000):
        #print "tag 0 " + str(i) + " " + str(counter)
        if (counter == 0): break
        #if (i == 1086):
            #print str(i) + " counter: " + str(counter) + " one over: " + str(1.0/i) + " lcm: " + str(lcm(i, cN))
        if ((1.0/i) <= counter):
            #print "tag 1 " + str(i)
            #print "tag 1 " + str(i) + " " + str((1.0)/i) + " " + str(counter)
            newDenom = lcm(i, cN)
            firstNumer = cM * (newDenom / cN)
            secondNumer = (newDenom / i)
            diff = firstNumer - secondNumer
            _cM = diff / gcd(diff, newDenom)
            _cN = newDenom / gcd(diff, newDenom)
            if (_cN >= 1000000):
                i += 1
                continue
            else:
                cM = _cM
                cN = _cN
                i -= 1
            counter = float(cM) / cN
            #print "counter " + str(counter)
            denominators.append(i+1)
        else: i += 1

    s = ""
    for i in denominators:
        s += str(i) + " "

    print s.strip()
