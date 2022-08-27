import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int,input().split()))
trees.sort()
start, end = [0, max(trees)]

while start <= end:
    mid = (start + end) // 2
    cut_tree = 0
    cut_trees = [tree-mid for tree in trees if tree > mid]
    cut_tree = sum(cut_trees)
    # for tree in trees:
    #     if tree > mid:
    #         cut_tree += (tree - mid)
    
    if cut_tree >= m: 
        start = mid + 1
    else:
        end = mid - 1

print(end)