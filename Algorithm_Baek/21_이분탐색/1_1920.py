import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int,input().split()))
m = int(input())
B = list(map(int,input().split()))

def find_recursion(target, data, start, end):
    if start > end:
        return 0

    mid = (start + end) // 2

    if data[mid] == target:
        return 1
    elif data[mid] > target:
        end = mid - 1
    else:
        start = mid + 1

    return find_recursion(target, data, start, end)


A.sort()
for b in B:
    print(find_recursion(b,A,0,n-1))

