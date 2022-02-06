import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int,input().split())))

global count
count = 0
def f (arr, n):
    global count
    # 탈출포인트1 - recursion에러 방지
    if n == 1:
        count+=1
        if arr[0][0] == 0 : 
            return 0
        else:
            return 1

    # 탈출포인트2
    sum_value = 0
    for a in arr:
        sum_value+=sum(a)
    if sum_value == 0:
        count+=1
        return 0
    if sum_value == n*n:
        count+=1
        return 1
    
    # 4 ways
    num = n//2
    new_arr1 = [arr2[:num] for arr2 in arr[:num]]
    new_arr2 = [arr2[:num] for arr2 in arr[num:]]
    new_arr3 = [arr2[num:] for arr2 in arr[num:]]
    new_arr4 = [arr2[num:] for arr2 in arr[:num]]

    return f(new_arr1, num) + f(new_arr2, num) + f(new_arr3, num) + f(new_arr4, num)
    
x = f(arr,n)
print(count-x)
print(x)