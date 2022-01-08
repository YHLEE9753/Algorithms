while True:
    n, *heights = list(map(int, input().split()))
    if(n==0):
        break

    heights.insert(0,0)
    heights.append(0)

    checked = [0]
    area = 0

    # 현재 높이보다 이전 높이가 높으면, while 진입
    # 현재 높이가 더 낮으면 넓이를 이어서 계산할 수 없다.
    # 따라서 이전 시점까지 저장되었던 사각현의 높이를 계산한다
    # 끝 사각형도 고려해야 하므로, n+1 까지 반복한다.
    for i in range(1, n+2): # 0 과 n+1 은 비교군
        # heights[checked[-1]]은 이전 시점의 사각형 높이
        # heights[i] 는 현재 시점의 사각형 높이
        # heights[checked[-1]] > heights[i] 는 현재 높이보다 이전 높이가 높은지 확인
        while(checked and (heights[checked[-1]]> heights[i])):

            cur_height = checked.pop()
            area = max(area, (i-1-checked[-1]) * heights[cur_height])
        checked.append(i)
    print(area)