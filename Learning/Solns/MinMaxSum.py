a = [1, 2, 3, 4, 5]

# 14/15 cases passed, Test case 13 is not passing (can't see cause need hackerrank subscription)


def min_max(arr):
    result = list()
    for idx_i, i in enumerate(arr):
        sum = 0
        for idx_j, j in enumerate(arr):
            if idx_i == idx_j:
                continue
            else:
                sum += j
        result.append(sum)
    result.sort()
    print(result[0], result[-1])


min_max(a)
