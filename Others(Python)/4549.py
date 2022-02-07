import sys
input = sys.stdin.readline

while True:
    words = input().rstrip()
    # 탈출포인트
    if words == ".":
        break

    words = words[:-1]

    stack = []
    for word in words:
        if word == "[" or word == "]" or word == ")" or word == "(":
            if stack:
                val = stack[-1]
            else:
                stack.append(word)
                continue

            if (val == "(" and  word == ")") or (val == "[" and word == "]"):
                stack.pop()
            else:
                stack.append(word)

    if len(stack) == 0:
        print("yes")
    else:
        print("no")      

