import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs(graph, x, y):
    queue = deque()
    queue.append([x, y, 1]) # x좌표, y좌표, 거리
    visited = []
    case = []

    while queue:
        nodex, nodey, nodedepth = queue.popleft()
        
        # 도착 시
        if nodex == n-1 and nodey == m-1:
            case.append(nodedepth)

        for i in range(4):
            nx = nodex + dx[i]
            ny = nodey + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m or [nx,ny] in visited:
                continue
            visited.append([nx,ny])
            if graph[nx][ny] == 1:
                queue.append([nx,ny,nodedepth+1])
    
    return case

graph = []
for _ in range(n):
    graph.append(list(map(int,input()[:m])))
print(min(bfs(graph, 0,0)))


