import sys
input = sys.stdin.readline
n,m,v = map(int,input().split())

# make graph
graph = {}
for i in range(1,n+1):
    graph[i] = []
for i in range(m):
    x,y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

# dfs
def dfs(graph, start):
    visited = []
    stack = [start]
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.append(node)
            temp = list(set(graph[node])-set(visited))
            temp.sort(reverse=True)
            stack.extend(temp)
    return visited

# bfs
from collections import deque
def bfs(graph, start):
    visited = []
    queue = deque([start])
    while queue:
        node = queue.popleft()
        if node not in visited:
            visited.append(node)
            temp = list(set(graph[node])-set(visited))
            temp.sort()
            queue.extend(temp)
    return visited

# answer
print(" ".join(list(map(str,dfs(graph,v)))))
print(" ".join(list(map(str,bfs(graph,v)))))