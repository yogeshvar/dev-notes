arr = [4, 3, 2, 7, 8, 2, 3, 1]
counter = list(range(1, len(arr)+1))

print(list(set(counter) - set(arr)))
