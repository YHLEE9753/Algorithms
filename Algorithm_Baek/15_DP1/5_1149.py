import sys
input = sys.stdin.readline

memo = []
number = int(input())
for _ in range(number):
    memo.append(list(map(int,input().split())))

for i in range(1,number):
    memo[i][0] = min((memo[i-1][1]+memo[i][0]),(memo[i-1][2]+memo[i][0]))
    memo[i][1] = min((memo[i-1][0]+memo[i][1]),(memo[i-1][2]+memo[i][1]))
    memo[i][2] = min((memo[i-1][0]+memo[i][2]),(memo[i-1][1]+memo[i][2]))

print(min(memo[number-1][0], memo[number-1][1], memo[number-1][2]))