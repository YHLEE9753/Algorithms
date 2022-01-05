import sys
from collections import deque
input = sys.stdin.readline

dx = [1,1,2,2,-1,-1,-2,-2]
dy = [2,-2,1,-1,2,-2,1,-1]

def bfs(start,end,graph,size):
    queue = deque()
    visited = graph
    queue.append(start)
    while queue:
        node = queue.popleft()
        x = node[0]
        y = node[1]
        # 탈출 포인트
        if node == end:
            return visited[x][y]
        # 
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= size or ny < 0 or ny >= size:
                continue
            if visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                queue.append([nx,ny])

    return -1

n = int(input())
for i in range(n):
    size = int(input())
    start = list(map(int,input().split()))
    end = list(map(int,input().split()))
    graph = [[0 for _ in range(size)] for _ in range(size)]
    print(bfs(start,end,graph,size))

