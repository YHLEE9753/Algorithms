import sys
input = sys.stdin.readline

memo = []
n = int(input())
for _ in range(n):
    memo.append(list(map(int,input().split())))

for i in range(1,n):
    for j in range(len(memo[i])):
        if j == 0:
            memo[i][j] = memo[i][j] + memo[i-1][j]
        elif j == len(memo[i])-1:
            memo[i][j] = memo[i][j] + memo[i-1][j-1]
        else: 
            memo[i][j] = memo[i][j] + max(memo[i-1][j],memo[i-1][j-1]) 

print(max(memo[n-1][i] for i in range(n)))
