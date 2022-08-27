import sys
input = sys.stdin.readline

n, k = map(int,input().split())
arr = []
for i in range(n):
    w, v = map(int,input().split())
    arr.append([w,v])

dp = [[0]*(k+1) for _ in range(n+1)]

for i in range(n):
    for j in range(k):
        w = arr[i][0]
        v = arr[i][1]
        if w > j+1:
            dp[i+1][j+1] = dp[i][j+1]
        else:
            dp[i+1][j+1] = max(v + dp[i][j+1-w], dp[i][j+1])
            
print(dp[-1][-1])

