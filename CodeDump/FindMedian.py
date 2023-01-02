a = [0, 1, 2, 4, 6, 5, 3]


def find_median(arr):
    arr.sort()
    if len(arr) % 2 is not 0:
        median_idx = len(arr) // 2
        return arr[median_idx]
    else:
        median_idx = len(arr) // 2
        return (arr[median_idx] + arr[median_idx - 1]) / 2


print(find_median(a))
