import sys
input = sys.stdin.readline

memo = [0 for _ in range(101)]
def dp(n:int)->int:
    if memo[n]>0:
        return memo[n]
    if n == 1 or n == 2 or n==3:
        memo[n] = 1
        return 1 
    if n ==4 or n==5:
        memo[n] = 2
        return 2

    memo[n] = dp(n-5) + dp(n-1)
    return memo[n]

for _ in range(int(input())):
    print(dp(int(input())))