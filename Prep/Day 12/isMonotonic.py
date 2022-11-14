def isMonotonic(array):
    isIncrease = 0
    isDecrease = 0
    if len(array) == 0:
        return True
    for a in range(len(array) - 1):
        if array[a] == array[a+1]:
            isIncrease += 1
            isDecrease += 1
        if array[a] > array[a+1]:
            isIncrease += 1
        elif array[a] < array[a+1]:
            isDecrease += 1

    if isIncrease == len(array) - 1 or isDecrease == len(array) - 1:
        return True
    return False
