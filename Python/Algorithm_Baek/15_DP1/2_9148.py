import sys
input = sys.stdin.readline


def fi1(a:int,b:int,c:int)->int:
    if a<=0 or b<=0 or c<=0:
        return 1
    if a>20 or b>20 or c>20:
        return fi1(20,20,20)
    if memo[a][b][c]:
        return memo[a][b][c]
    if a<b and b<c:
        memo[a][b][c] = fi1(a,b,c-1) + fi1(a,b-1,c-1) - fi1(a, b-1, c)
        return memo[a][b][c]
    else:
        memo[a][b][c] = fi1(a-1,b,c) + fi1(a-1,b-1,c) + fi1(a-1,b,c-1) - fi1(a-1,b-1,c-1)
        return memo[a][b][c]

memo = [[[0]*(21) for _ in range(21)]for _ in range(21)]

while True:
    a,b,c = map(int,input().split())
    # exit
    if a==-1 and b==-1 and c==-1:
        break
    ans = fi1(a,b,c)
    print("w({}, {}, {}) = {}".format(a,b,c,ans))