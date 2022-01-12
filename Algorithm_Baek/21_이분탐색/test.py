import sys
input = sys.stdin.readline

k, n = map(int, input().split())
lines = [int(input()) for _ in range(k)]
lines.sort()
start, end = [1, max(lines)]

def find(data, val):
    result = 0
    for d in data:
        result += d // val
    return result

while start <= end:
    mid = (start + end) // 2
    value = find(lines, mid)

    if value < n:
        end = mid - 1
    else:
        start = mid + 1

print(end)


