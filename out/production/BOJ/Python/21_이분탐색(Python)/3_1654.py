import sys
input = sys.stdin.readline

k, n = map(int,input().split())
li = [int(input()) for _ in range(k)]
li.sort()
start = 1 #이분탐색 처음과 끝위치
end = max(li)

while start <= end: #적절한 랜선의 길이를 찾는 알고리즘
    mid = (start + end) // 2 #중간 위치
    lines = 0 #랜선 수
    for i in li:
        lines += i// mid #분할 된 랜선 수
        
    if lines >= n: #랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1
    
print(end)
