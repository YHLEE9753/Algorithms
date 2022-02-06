import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
arr.sort()

dp1 = [1] * n
dp2 = [1] * n
for i in range(n):
    for j in range(i):
        if arr[i][1]>arr[j][1]:
            dp1[i] = max(dp1[i], dp1[j]+1)

a = max(dp1)
print(n-a)
