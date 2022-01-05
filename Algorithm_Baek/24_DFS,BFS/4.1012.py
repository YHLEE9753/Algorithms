import sys
from collections import deque
input = sys.stdin.readline

# 초기 필요 변수
dx = [0,0,1,-1]
dy = [1,-1,0,0]

# 메인 함수
def check(i,j, graph):
    graph[i][j] = 0
    queue = deque([[i,j]])
    n = len(graph)
    
    while queue:
        x, y = queue.popleft()
        for k in range(4):
            rx = x + dx[k]
            ry = y + dy[k]
            if rx < 0 or rx >= n or ry < 0 or ry >= n:
                continue
            if graph[rx][ry] == 1:
                graph[rx][ry] = 0
                queue.append([rx,ry])
    return None


# 입력 시작
t = int(input())
for _ in range(t):
    n, m, k = map(int,input().split())
    # graph = [[0 for _ in range(m)] for _ in range(n)] 차이가 뭐냐....
    graph = [[0]*m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1
    
    # 로직 시작
    answer = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                check(i,j, graph)
                answer += 1
    print(answer)



    

