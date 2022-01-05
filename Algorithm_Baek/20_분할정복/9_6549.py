import sys
input = sys.stdin.readline

def find(heights, n):
    for h in list(set(heights)).sort(reverse=True):
        for bottom in range(n,0,-1):
            # check
            for i in range(n-bottom+1):
                for j in range(max_h-h+1):
                    
            pass
    return 0

while(True):
    X = input()
    if X == '0\n':
        break
    inputs = list(map(int,X.split()))
    n = inputs[0]
    heights = inputs[1:]
    max_h = max(heights)
    # 좌표계 생성
    dots = [[0]*n for _ in range(max_h)]
    for i in range(max_h):
        for j in range(n):
                if heights[j] > i:
                    dots[i][j] = 1
                else:
                    dots[i][j] = 0

    # result = find(heights,n)
    # print(result)
