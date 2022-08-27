import sys
input = sys.stdin.readline

a = int(input())
b = int(input())

# graph 만들기
graph = {}
for n in range(1,a+1):
    graph[n] = []
for n in range(1,b+1):
    x,y = map(int,input().split(" "))
    graph[x].append(y)
    graph[y].append(x)

# dfs 구현
def dfs(graph, start):
    visited = []
    stack = [start]
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.append(node)
            temp = list(set(graph[node])-set(visited))
            stack.extend(temp)
    return visited

print(len(dfs(graph,1))-1)
    


