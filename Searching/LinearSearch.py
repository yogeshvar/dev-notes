arr = [1, 2, 3, 4, 1]
find_element = 5

for i in range(len(arr)):
    if arr[i] is find_element:
        print i
        break
    else:
        print -1
        break
