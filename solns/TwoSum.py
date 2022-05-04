array = [2, 7, 11, 15]
target = 9

# TODO: Find more optimal solution.

for i in range(0, len(array)):
    for j in range(i, len(array)):
        if array[i] + array[j] == target and i is not j:
            print(i, j)
