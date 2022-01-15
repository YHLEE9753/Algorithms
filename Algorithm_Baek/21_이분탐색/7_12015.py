import sys
input = sys.stdin.readline

n = int(input())
cases = list(map(int,input().split()))
memo = [0]

for case in cases:
    if memo[-1] < case:
        memo.append(case)
    else:
        start = 0
        end = len(memo)

        while start < end:
            mid = (start + end) // 2
            if memo[mid] < case:
                start = mid + 1
            else:
                end = mid
        memo[end] = case

print(len(memo)-1)