import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]


result = []
def f(x, y, n):
    start = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != start:
                num = n//3
                for k in range(3):
                    for l in range(3):
                        f(x+num*k,y+num*l,num)
                return
             
    result.append(start)

f(0,0,n)
print
print(result.count(-1))
print(result.count(0))
print(result.count(1))