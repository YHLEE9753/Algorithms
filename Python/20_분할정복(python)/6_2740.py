import sys
input = sys.stdin.readline

arrs = []
n1,m1 = map(int,input().split())
arr1 = []
for _ in range(n1):
    arr1.append(list(map(int,input().split())))

n2,m2 = map(int,input().split())
arr2 = []
for _ in range(n2):
    arr2.append(list(map(int,input().split())))


result = [[0 for _ in range(m2)] for _ in range(n1)]
for i in range(n1):
    for j in range(m2):
        ans = 0
        for k in range(m1):
            ans += arr1[i][k] * arr2[k][j]
        result[i][j] = ans

for i in result:
    for j in i:
        print(j, end = ' ')
    print()


    

