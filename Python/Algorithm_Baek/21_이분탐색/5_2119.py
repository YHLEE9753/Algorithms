import sys
input = sys.stdin.readline

n, c = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()
start, end = [1, houses[-1]] 

while start <= end:
    mid = (start + end) // 2
    point = houses[0] # 맨 처음 시작점은 맨 앞의 점
    count = 1 # 공유기 갯수와 비교하기 위한 변수

    for h in houses: # 모든 집들을 검토
        if h >= point + mid: # point 에서 mid 를 더한다.
            count += 1 # 그다음 점 존재하므로 count 1증가
            point = h # 포인트를 그다음 점으로 옮긴다. 그러면 자동으로 if 절에서 그 다음 값을 찾을 것이다.
            
    if count >= c: 
        start = mid + 1
    else:
        end = mid - 1

print(end)