n, x = [int(e) for e in input().split()]

chapter_subjects = [int(e) for e in input().split()]
chapter_subjects.sort()

total = 0
for i in range(n):
    total += max(x-i, 1) * chapter_subjects[i]

print(total)
