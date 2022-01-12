import sys
input = sys.stdin.readline

n, c = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()
start, end = [1, houses[-1]]

while start <= end:
    mid = (start + end) // 2
    print(mid)

    point = houses[0]
    count = 1
    flag = True
    while count < c:
        print("!")
        point += mid
        flag2 = True
        for h in houses:
            if h >= point:
                count += 1
                point = h
                break
        
    if flag:
        start = mid + 1
    else:
        end = mid - 1

print(end)