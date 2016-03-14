gunnar_dice = [int(e) for e in input().split()]
emma_dice = [int(e) for e in input().split()]

def build_list(dice):
    result = list()
    for i in range(dice[0], dice[1]+1):
        for j in range(dice[2], dice[3]+1):
            result.append(i + j)
    return result

emma, gunnar = build_list(emma_dice), build_list(gunnar_dice)
emma_count, gunnar_count = 0, 0
for e in emma:
    for g in gunnar:
        if e > g:
            emma_count += 1
        elif g > e:
            gunnar_count += 1

if emma_count > gunnar_count:
    print('Emma')
elif gunnar_count > emma_count:
    print('Gunnar')
else:
    print('Tie')
