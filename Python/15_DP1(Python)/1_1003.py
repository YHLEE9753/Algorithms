import sys
input = sys.stdin.readline

#[fi결과, 0횟수, 1횟수]
memo = [[0,0,0] for _ in range(41)]

# bottom up
def fi1(n:int) -> int:
    memo[0] = [0,1,0]
    memo[1] = [1,0,1]
    for i in range(2,n+1):
        # memo[i][0] = memo[i-1][0] + memo[i-2][0]
        memo[i][1] = memo[i-1][1] + memo[i-2][1]
        memo[i][2] = memo[i-1][2] + memo[i-2][2]
    return memo[n]



for _ in range(int(input())):
    answer = fi1(int(input()))
    print('{} {}'.format(answer[1],answer[2]))