import sys
import math
input = sys.stdin.readline

def find(x,y):
    dist = y-x
    inc = math.floor(math.sqrt(dist))
    inc2 = inc + (inc-1)
    dist2 = dist - inc*inc
    dec = 0

    if dist2 > 0:
        dec += math.ceil(dist2/inc)
    return (inc2 + dec)

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    print(find(x,y))

