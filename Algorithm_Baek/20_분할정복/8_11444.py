import sys
input = sys.stdin.readline

n = int(input())
mod = 1_000_000_007

arr = [[1,1],[1,0]]


# 곱셈 출력
def mul(arr1, arr2):
    result = [[0 for _ in range(2)] for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                result[i][j] += arr1[i][k] * arr2[k][j]
            result[i][j] %= mod
    return result

# 제곱으로 해결
def power(final, b):
    if b == 0:
        return [[0]]
    if b == 1:
        return arr

    temp = power(final, b//2)
    if b%2 == 0:
        return mul(temp,temp)
    else:
        return mul(mul(temp,temp),arr)

# 계산
if n == 0:
    print(0)
elif n ==1:
    print(1)
else:
    result = power(arr, n-1)
    print(result[0][0])
