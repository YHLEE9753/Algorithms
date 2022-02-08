import sys
input = sys.stdin.readline

n, k = map(int, input().split())

value_list = [int(input()) for _ in range(n)]

count = 0
for i in range(n-1,-1,-1):
    count += k//value_list[i]
    k = k%value_list[i]
print(count)