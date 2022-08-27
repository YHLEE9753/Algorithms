import sys
input = sys.stdin.readline

arr = input().strip().split("-")
if arr[0] == '':
    first = [0]
else:
    first = list(map(int,arr[0].split("+")))
first = sum(first)

result = 0
for i in range(1,len(arr)):
    second = list(map(int,arr[i].split("+")))
    result += sum(second)

print(first-result)