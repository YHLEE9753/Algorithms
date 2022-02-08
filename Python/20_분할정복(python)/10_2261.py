import sys
input = sys.stdin.readline

n = int(input())
coors = [list(map(int,input().split())) for _ in range(n)]
coors.sort()

def dist_points(p1,p2):
    return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2

def solve(start, end):
    # 점 하나의 경우 거리 존재X
    if start == end:
        return float('inf')
    
    # 점 2개 사이의 거리
    if end - start == 1:
        return dist_points(coors[start], coors[end])

    # 중앙값 설정
    mid = (start + end)//2
    minDist = min(solve(start, mid), solve(mid, end))

    # x 축을 기준으로 후보 점들을 찾는다(1단계)
    target_coors = []
    for i in range(start, end+1):
        if (coors[mid][0] - coors[i][0])**2 < minDist:
            target_coors.append(coors[i])
    
    # y 축 정렬
    target_coors.sort(key=lambda x : x[1])

    # y 축을 기준으로 후보 점들 사이 거리 비교 (2단계)
    size = len(target_coors)
    for i in range(size):
        for j in range(i+1,size):
            if(target_coors[i][1] - target_coors[j][1])**2 < minDist:
                minDist = min(minDist, dist_points(target_coors[i], target_coors[j]))
            else:
                # 현재 후보 점이 다음 점과 최소거리보다 멀다면 더 이상 볼 필요가 없다. (부재시 시간초과)
                break
    
    return minDist

print(solve(0, n-1))
