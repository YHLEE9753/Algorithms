import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))
dic = {}

for a in A:
    if a in dic:
        dic[a] += 1
    else:
        dic[a] = 1

for b in B:
    if b in dic:
        print(dic[b], end=" ")
    else:
        print("0", end=" ")
