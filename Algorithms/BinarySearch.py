arr = [2, 5, 8, 12, 16, 23, 38, 56, 72, 91]


def binary_search(array, low, high, key):
    if high >= 1:
        mid = (low + high) // 2

        # print low, high, mid, array[mid]
        if array[mid] == key:
            print(mid)

        elif array[mid] > key:
            return binary_search(array, 1, mid - 1, key)

        else:
            print(arr[mid+1:high])
            return binary_search(array, mid + 1, high, key)
    else:
        print -1


binary_search(arr, 0, len(arr) - 1, 56)
