import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

start = 0
end = n*n

def find_index(num):
    index = 0
    for i in range(1,n+1):
        index += min(num//i,n)
    return index
    
while start <= end:
    mid = (start + end) // 2
    index = find_index(mid)
    
    if index == k:
        end = start
    elif index < k:
        start = mid + 1
    else:
        end = mid - 1

print(end+1)
