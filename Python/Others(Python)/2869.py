import sys
import math
input = sys.stdin.readline

a,b,c = map(int, input().split())
# 올라가고 
# 내려가고
# 하루 지나고
# 1. 올라가고 자기전에 달성
# 2. 올라가고 달성못해서 다시 내려가고

distance = c - a
days = math.ceil(distance / (a-b))

while distance < c:
    days += 1
    # 1. 올라가고 자기전에 달성
    distance += a
    if distance >= c:
        break
    distance -= b
    print(distance)
print(days)