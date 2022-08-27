import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

def bfs(start, end):
    queue =deque()
    depth = 0
    queue.append([start,depth])
    visited = [start]
    
    while queue:
        node = queue.popleft()
        if node[0] == end:
            return node[1]

        depth = node[1] + 1
        newnodes = [node[0] - 1, node[0] + 1, node[0] * 2]
        for n in newnodes:
            if n not in visited and 0<n<=100000:
                visited.append(n)
                queue.append([n,depth])  

    return None

print(bfs(n,k))