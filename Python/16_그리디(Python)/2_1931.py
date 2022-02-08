import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    x, y = map(int,input().split())
    arr.append([x,y])
arr.sort(key = lambda x : (x[1],x[0]))

end = arr[0][1]
count = 1
for i in range(1,len(arr)):
    if arr[i][0]>=end:
        end = arr[i][1]
        count+=1

print(count)