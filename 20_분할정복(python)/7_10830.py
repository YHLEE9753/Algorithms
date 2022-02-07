import sys
input = sys.stdin.readline

n, b = map(int,input().split())
mod = 1000
arr = [list(map(int,input().split())) for _ in range(n)]

# 입력값이 1000 이면서 곱셈을 1번만하는 경우 예외처리
if b == 1:
    for i in range(len(arr)):
        for j in range(len(arr)):
            arr[i][j] = arr[i][j] % 1000

# 곱셈 출력
def mul(arr1, arr2):
    result = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += arr1[i][k] * arr2[k][j]
            result[i][j] %= 1000
    return result

# 제곱으로 해결
def power(final, b):
    if b == 1:
        return final

    temp = power(final, b//2)
    if b%2 == 0:
        return mul(temp,temp)
    else:
        return mul(mul(temp,temp),arr)

# 계산
result = power(arr, b)


# 정답 출력
for i in result:
    for j in i:
        print(j, end = " ")
    print()
