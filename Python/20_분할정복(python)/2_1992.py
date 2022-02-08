import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,list(input().strip()))) for _ in range(n)]

global result
result = ""
def f(arr, n):
    global result
    
    sum_v = 0
    for ar in arr:
        sum_v += sum(ar)
    if sum_v == n*n:
        result += '1'
        return 
    elif sum_v == 0:
        result += '0'
        return

    num = n//2
    result += '('
    f([a[:num] for a in arr[:num]], num)
    f([a[num:] for a in arr[:num]],num)
    f([a[:num] for a in arr[num:]],num)
    f([a[num:] for a in arr[num:]],num)
    result += ")"
    return 

f(arr,n)
print(result)