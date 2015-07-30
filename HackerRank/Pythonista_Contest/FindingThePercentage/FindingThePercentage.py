#HackerRank Pythonista Contest
#Finding the Percentage

numStudents = int(input());
gradeBook = {}
for i in range(numStudents):
    line = input().split()
    gradeBook.update({line[0] : (float(line[1]), float(line[2]), float(line[3]))})

name = input()

counter = 0;
for x in gradeBook[name]:
    counter += x

print("%.2f" % (counter/3))
