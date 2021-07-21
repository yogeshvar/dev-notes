import math
arr = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]


def jump_search(array, key):
    steps = int(math.sqrt(len(array)))

    currentStep = 0
    while arr[currentStep] < key:
        currentStep += steps

    for i in range(currentStep - steps, len(arr)):
        if arr[i] is key:
            print(i)
            break


jump_search(arr, 55)
