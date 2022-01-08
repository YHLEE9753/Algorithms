# 바이너리 서치
# data 중에서 target 을 검색하여 index 값을 return 한다.
# 없으면 None을 return한다.
def binary_search(target, data):
    data.sort()
    start = 0
    end = len(data) - 1
    
    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return mid
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid -1

    return None


li = [i**2 for i in range(11)]
target = 9
idx = binary_search(target, li)


# 바이너리 서치 재귀적 구현
# data는 오름차순으로 정렬된 리스트
def binary_search_recursion(target, start, end, data):
    if start > end:
        return None

    mid = (start + end) // 2
    
    if data[mid] == target:
        return mid
    elif data[mid] > target:
        end = mid - 1
    else:
        start = mid + 1
    
    return binary_search_recursion(target, start, end, data)



li = [i*3 for i in range(11)]
target = 6
idx = binary_search_recursion(target, 0, 10, li.sort())