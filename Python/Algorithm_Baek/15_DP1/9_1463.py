import sys
input = sys.stdin.readline

n = int(input())
d = [0 for _ in range(n+1)]

for i in range(2,n+1):
    d[i] = d[i-1] + 1
    ## 여기서 if elif else를 사용하면 안된다. if만 이용해야 세 연산을 다 거칠 수 있다,
    ## 정해진 최선의 연산 방법이 없기 때문에 다 시도해보아야 한다.
    if i % 3 == 0:
        d[i] = min(d[i], d[i//3] + 1)
    if n % 2 == 0:
        d[i] = min(d[i], d[i//2] + 1)

print(d[n])

n = int(input())
d = [0 for _ in range(n+1)]

for i in range(2, n + 1):
    d[i] = d[i - 1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)	
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
print(d[n])