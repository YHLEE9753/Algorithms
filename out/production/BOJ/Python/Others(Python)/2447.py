import sys
input = sys.stdin.readline

def func(n):
    if n == 1:
        return ["*"]
    
    Stars = func(n//3)
    L = []

    for S in Stars:
        L.append(S*3)
    for S in Stars:
        L.append(S+" "*(n//3)+S)
    for S in Stars:
        L.append(S*3)
    return L

n = int(input())
print("\n".join(func(n)))