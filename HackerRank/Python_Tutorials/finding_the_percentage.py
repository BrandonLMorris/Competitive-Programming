n = int(input())
grade_book = {}
for i in range(n):
    student = input().split()
    grade_book[student[0]] = [float(student[1]), float(student[2]), float(student[3])]

name = input()
total = grade_book[name][0] + grade_book[name][1] + grade_book[name][2]

print("%.2f" % (total/3))
