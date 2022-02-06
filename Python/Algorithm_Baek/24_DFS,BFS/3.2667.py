from collections import deque
import sys

input = sys.stdin.readline
dx = [0,0,-1,1]
dy = [1,-1,0,0]

def check(point):
    queue = deque([point])
    apart[point[0]][point[1]] = 0
    limit = len(apart)
    count = 1 # visited 대신

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= limit or ny < 0 or ny >= limit:
                continue
            if apart[nx][ny] == 1:
                apart[nx][ny] = 0
                queue.append([nx,ny])
                count += 1

    return count
    

n = int(input())
apart = []
for i in range(n):
    temp = list(map(int,list(str(input())[0:n])))
    apart.append(temp)


villages = []
for i in range(n):
    for j in range(n):
        if apart[i][j] == 1:
            villages.append(check([i,j]))

print(len(villages))

villages.sort()
for v in villages:
    print(v)