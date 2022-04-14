a = [1, 2, 3, 4, 3, 2, 1]


def lonely_integer(arr):
    unique_num = set(arr)
    for num in unique_num:
        if arr.count(num) == 1:
            return num


print(lonely_integer(a))
