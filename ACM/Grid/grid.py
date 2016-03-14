# pylint: disable-all
from collections import deque

rows, columns = [int(e) for e in input().split()]

in_bounds = lambda x, y: (x >= 0 and x < rows) and (y >= 0 and y < columns)

grid = list()
for i in range(rows):
    grid.append([int(e) for e in list(input())])

target = (rows - 1, columns - 1)
count, counts = 0, {(0, 0): 0}
queue = deque()
queue.append((0, 0))
visited = set()

while len(queue) > 0:
    pos = queue.popleft()
    if pos == target:
        break
    visited.add(pos)
    step = grid[pos[0]][pos[1]]

    if step == 0: continue

    left, right, up, down = ((pos[0], pos[1] - step), (pos[0], pos[1] + step),
                             (pos[0] - step, pos[1]), (pos[0] + step, pos[1]))

    for _next in left, right, up, down:
        if in_bounds(_next[0], _next[1]) and _next not in visited:
            queue.append(_next)
            counts[_next] = counts[pos] + 1
            visited.add(_next)

print(counts[target] if target in counts else '-1')
