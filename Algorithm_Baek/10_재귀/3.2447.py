import sys
input = sys.stdin.readline

def make(n:int) -> int:
    global map

    if n == 3:
        map[0:3] = map[2:3] = [1,1,1]
        map[1:0] = map[1,2] = 1
    if

    return

number = int(input())
map = [[0 for _ in range(number)] for _ in range(number)]
print(make(number))