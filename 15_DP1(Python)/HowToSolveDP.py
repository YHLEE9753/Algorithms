import sys
input = sys.stdin.readline
n = int(input())

# 1. 일반 피보나치
def fi1(n: int) -> int:
    if n <= 1:
        return n
    else:
        return fi1(n-1) + fi1(n-2)

# 2. top-down
memo = [0 for i in range(100)]
def fi2(n:int) -> int:
    if n <= 1:
        return n
    else:
        if memo[n] > 0:
            return memo[n]
        memo[n] = fi2(n-1) + fi2(n-2)
        return memo[n]

# 3. Bottom-up
memo = [0 for i in range(100)]
def fi3(n:int) -> int:
    memo[0] = 0
    memo[1] = 1
    for i in range(2, n+1):
        memo[i] = memo[i-1] + memo[i-2]
    return memo[n]



