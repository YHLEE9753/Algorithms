import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph, start):
    queue = deque()
    visited = []
    queue.append(start)

    while queue:
        node = queue.popleft()
        visited.append(node)
        if node not in visited:
            queue.extend(graph[node])        

    return

n = int(input())
for _ in range(n):
    v, e = map(int, input().split())
    graph = {}
    a = 0
    for _ in range(e):
        a, b = map(int, input().split())
        if a not in graph:
            graph[a] = []
        if b not in graph:
            graph[b] = []
        graph[a].append([b,0])
        graph[b].append([a,0])
    print(bfs(graph,a))