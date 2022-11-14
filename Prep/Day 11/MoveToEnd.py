def moveElementToEnd(array, toMove):
    tmp = 0
    for i in range(len(array)):
        if array[i] != toMove:
            array[i], array[tmp] = array[tmp], array[i]
            tmp += 1
    return array


moveElementToEnd([2, 1, 2, 2, 2, 3, 4, 2], 2)
