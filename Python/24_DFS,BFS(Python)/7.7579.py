import sys
from collections import deque
input = sys.stdin.readline



m, n, h = map(int,input().split())
boxs = []
for floor in range(h):
    boxs.append([])
    for samefloor in range(n):
        temp = list(map(int,input().split()))
        boxs[floor].append(temp)


# 처음 1의 좌표 찾기
def first_find(graph):
    result = []
    for f in range(h):
        for x in range(m):
            for y in range(n):
                if graph[f][y][x] == 1:
                    result.append([f,x,y])
    return result

# dfs 처리
dx = [0,0,-1,1, 0,0]
dy = [1,-1,0,0, 0,0]
dh = [0,0,0,0,  1,-1]

def dfs(graph, start):
    stack = start
    visited = []
    count = 0
    while True:
        # 더이상 바뀌는게 있는지 없는지 체크
        breakpoint = 0
        while stack:
            rh, rx, ry = stack.pop()
            for i in range(6):
                nh = rh + dh[i]
                nx = rx + dx[i]
                ny = ry + dy[i]
                if nx < 0 or nx >= m or ny < 0 or ny >= n or nh < 0 or nh >= h or graph[nh][ny][nx] == -1 or graph[nh][ny][nx] == 1:
                    continue
                breakpoint += 1
                graph[nh][ny][nx] = 1
                visited.append([nh,nx,ny])
        if breakpoint == 0:
            break
        # stack 을 visited 로 바꾸어주고 visited 는 다시 빈 리스트로 치환
        stack = visited[:]
        visited = []
        count += 1
    return count

# # 0 이 있는지 확인
def find_zero(graph):
    for f in range(h):
        for x in range(m):
            for y in range(n):
                if graph[f][y][x] == 0:
                    return True
    return False

start = first_find(boxs)
result = dfs(boxs, start)
if find_zero(boxs): result = -1
print(result)
