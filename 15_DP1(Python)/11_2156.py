import sys
input = sys.stdin.readline

n = int(input())
wine = [0]*10000
for i in range(n):
    wine[i] = int(input())

dp = [0 for _ in range(n+2)]
dp[0] = wine[0]
dp[1] = wine[0] + wine[1]
dp[2] = max(wine[0] + wine[2], wine[1] + wine[2], dp[1])

for i in range(3,n):
    a = dp[i-2] + wine[i]
    b = dp[i-3] + wine[i-1] + wine[i]
    c = dp[i-1]
    dp[i] = max(a,b,c)

print(dp[n-1])