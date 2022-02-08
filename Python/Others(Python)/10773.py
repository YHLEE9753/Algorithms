import sys
input = sys.stdin.readline

n = int(input())
stack = []
for _ in range(n):
    val = int(input())
    if val != 0:
        stack.append(val)
    else:
        stack.pop()
print(sum(stack))
