import sys
from typing import AnyStr
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

for b in B:
    print(A.count(b), end = " ")
