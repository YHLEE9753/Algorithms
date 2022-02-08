import sys
input = sys.stdin.readline

l1 = list(input().strip())
l2 = list(input().strip())
n1 = len(l1)
n2 = len(l2)
dp = [[0]*(n2+1) for _ in range(n1+1)]

for i in range(n1):
    for j in range(n2):
        if l1[i] == l2[j]:
            dp[i+1][j+1] = dp[i][j] + 1
        else:
            dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1])

print(dp[-1][-1])