arr = [1, 2, 3, 4, 1]
find_element = 5

for i in range(0, len(arr)):
    if arr[i] == find_element:
        print(i)
        break
    