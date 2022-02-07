import sys
input = sys.stdin.readline

n = int(input())

while n>1:
    for i in range(2,10_000_001):
        if n%i ==0:
            print(i)
            n = n//i
            break
