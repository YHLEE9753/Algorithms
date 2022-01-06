import sys
input = sys.stdin.readline

# 값 받기
while(True):
    val = input()
    if val == "0\n":
        break
    else:
        result = []
        heights = list(map(int,val.split()))[:1]
        heights.insert(0,0)
        heights.append(0)
        # heights = [[i,v] for i,v in enumerate(heights)]

        stack = []
        for idx, height in enumerate(heights):
            # idx = height[0]
            # h = height[1]

            if (not stack) or stack[-1][1]<=height[1]:
                stack.append(height)
            else:
                while stack[-1][1] > height[1]:
                    pop_height = stack.pop()
                    result.append((idx-pop_height[0])*(pop_height[1]))
                    if not stack:
                        break             
                stack.append(height)
        # 스택 비우기
        print(stack)
        final_idx = len(heights)
        while stack:
            pop_height = stack.pop()
            print(pop_height)
            result.append((final_idx-pop_height[0])*(pop_height[1]))
        print(result)
        print(max(result))
                
                



