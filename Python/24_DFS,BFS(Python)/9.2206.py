import sys
from collections import deque
input = sys.stdin.readline

dx = [0,0,1,-1]
dy = [1,-1,0,0]


def bfs(graph):
    queue = deque()
    queue.append([0,0,1])
    visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
    visited[0][0][1] = 1

    while queue:
        x, y, c = queue.popleft()
        # 탈출 포인트
        if x == n-1 and y == m-1:
            return visited[x][y][c]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 예외처리
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            
            # 벽을 한개 부숨
            if graph[nx][ny] == 1 and c == 1:
                visited[nx][ny][0] = visited[x][y][1] + 1
                queue.append([nx,ny,0])
            # 빈 방이라면
            elif graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[x][y][c] + 1
                queue.append([nx,ny,c])
        
    return -1


n, m = map(int, input().split())
graph = []
for i in range(n):
    newrow = list(map(int,list(input()[:m])))
    graph.append(newrow)
print(bfs(graph))


