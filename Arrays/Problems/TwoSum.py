array = [-1, -2, -3, -4, -5]
target = -8

# TODO: Find more optimal solution.

for i in range(0, len(array)):
    for j in range(i, len(array)):
        if array[i] + array[j] == target and i is not j:
            print i, j
