import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

l = [arr[0]] # 0 할당시 음수에서 예외발생 첫값을 할당하자
for i in range(1, n):
    l.append(max(l[i-1] + arr[i], arr[i]))
print(max(l))