import numpy as np

# Passed Test case with 12 Attributes.
AA = np.array([
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 195, 0, 0, 151, 141, 0, 34, 0, 0, 127, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 147, 0, 0, 0, 111, 0, 0, 0, 79],
    [0, 151, 0, 0, 230, 124, 0, 0, 0, 0, 0, 0],
    [0, 141, 0, 0, 124, 202, 89, 0, 91, 0, 80, 107],
    [0, 0, 0, 0, 0, 89, 184, 0, 0, 0, 0, 110],
    [0, 34, 0, 111, 0, 0, 0, 132, 0, 0, 44, 60],
    [0, 0, 0, 0, 0, 91, 0, 0, 187, 0, 0, 113],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 127, 0, 0, 0, 80, 0, 44, 0, 0, 168, 0],
    [0, 0, 0, 79, 0, 107, 110, 60, 113, 0, 0, 175]])

# Passed.
# AA = np.array([[1, 2, 3, 4, 5, 6, 7],
#                [110, 51, 0, 20, 49, 62, 37],
#                [51, 94, 48, 37, 62, 30, 13],
#                [0, 48, 85, 28, 33, 0, 0],
#                [20, 37, 28, 100, 0, 61, 44],
#                [49, 62, 33, 0, 110, 19, 22],
#                [62, 30, 0, 61, 19, 107, 82],
#                [37, 13, 0, 44, 22, 82, 105]])

# passed
# AA = np.array([[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13],
#                [245, 0, 0, 245, 0, 0, 0, 245, 0, 0, 0, 0, 0],
#                [0, 188, 108, 0, 0, 0, 0, 0, 136, 0, 0, 0, 0],
#                [0, 108, 195, 0, 0, 96, 0, 0, 144, 0, 99, 0, 133],
#                [245, 0, 0, 245, 0, 0, 0, 245, 0, 0, 0, 0, 0],
#                [0, 0, 0, 0, 177, 0, 0, 0, 0, 177, 119, 0, 0],
#                [0, 0, 96, 0, 0, 174, 0, 0, 121, 0, 0, 0, 0],
#                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#                [245, 0, 0, 245, 0, 0, 0, 245, 0, 0, 0, 0, 0],
#                [0, 136, 144, 0, 0, 121, 0, 0, 182, 0, 0, 0, 0],
#                [0, 0, 0, 0, 177, 0, 0, 0, 0, 177, 119, 0, 0],
#                [0, 0, 99, 0, 119, 0, 0, 0, 0, 119, 200, 0, 162],
#                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#                [0, 0, 133, 0, 0, 0, 0, 0, 0, 0, 162, 0, 217]])

# AA = np.array([[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17],
#                [232, 117, 88, 121, 75, 0, 0, 0, 56, 0, 0, 66, 0, 74, 42, 41, 0],
#                [117, 235, 77, 0, 0, 0, 0, 0, 0, 0, 0, 92, 0, 104, 0, 0, 86],
#                [88, 77, 211, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 60, 91],
#                [121, 0, 0, 248, 102, 0, 0, 0, 76, 0, 0, 103, 0, 0, 84, 0, 0],
#                [75, 0, 0, 102, 262, 74, 0, 62, 0, 0, 0, 0, 113, 0, 0, 0, 116],
#                [0, 0, 0, 0, 74, 249, 75, 146, 0, 0, 86, 0, 0, 0, 101, 0, 0],
#                [0, 0, 0, 0, 0, 75, 238, 73, 110, 89, 88, 0, 0, 0, 0, 72, 0],
#                [0, 0, 0, 0, 62, 146, 73, 270, 90, 0, 126, 0, 0, 0, 84, 108, 0],
#                [56, 0, 0, 76, 0, 0, 110, 90, 233, 0, 0, 0, 0, 0, 0, 0, 0],
#                [0, 0, 0, 0, 0, 0, 89, 0, 0, 244, 0, 0, 131, 134, 0, 87, 0],
#                [0, 0, 0, 0, 0, 86, 88, 126, 0, 0, 277, 0, 0, 0, 0, 151, 0],
#                [66, 92, 0, 103, 0, 0, 0, 0, 0, 0, 0, 239, 0, 0, 104, 0, 0],
#                [0, 0, 0, 0, 113, 0, 0, 0, 0, 131, 0, 0, 263, 129, 0, 0, 142],
#                [74, 104, 0, 0, 0, 0, 0, 0, 0, 134, 0, 0, 129, 253, 0, 0, 0],
#                [42, 0, 62, 84, 0, 101, 0, 84, 0, 0, 0, 104, 0, 0, 244, 0, 0],
#                [41, 0, 60, 0, 0, 0, 72, 108, 0, 87, 151, 0, 0, 0, 0, 255, 0],
#                [0, 86, 91, 0, 116, 0, 0, 0, 0, 0, 0, 0, 142, 0, 0, 0, 24]])


# AA = np.array([
#     [1, 2, 3, 4],
#     [45, 0, 41, 0],
#     [0, 71, 1, 71],
#     [41, 1, 38, 1],
#     [0, 71, 1, 71]]
# )

# AA = np.array([[1, 2, 3, 4], [45, 0, 45, 0],
#                [0, 80, 5, 75],
#                [45, 5, 53, 3],
#                [0, 75, 3, 78]])

no_of_attr = len(AA) - 1


def bond(left, right):
    bond_value = 0
    # Boundary conditions
    if left == -1 or left == no_of_attr or right == -1 or right == no_of_attr:
        return bond_value
    else:
        bond_value = np.sum(np.multiply(
            AA[1:, left], AA[1:, right]))
        return bond_value


def contribution(left, middle, right):
    a = bond(left, middle)
    b = bond(middle, right)
    c = bond(left, right)
    if right == middle + 1:
        cont = 2 * a
    else:
        cont = 2 * (a + b - c)
    print("Ordering(", left + 1, middle + 1, right + 1, ")", "Bond value =>",  cont)
    return cont


def bea():
    CA = np.zeros(
        (no_of_attr + 1, no_of_attr), dtype=int)
    CA[:, 0] = AA[:, 0]
    CA[:, 1] = AA[:, 1]
    print("CA = ")
    print(CA)

    for index in range(2, no_of_attr):
        contribution_array = []

        for i in range(index):
            contribution_value = contribution(i - 1, index, i)
            contribution_array.append(contribution_value)

        contribution_array.append(contribution(index - 1, index, index + 1))

        loc = contribution_array.index(max(contribution_array))
        print("Loc = ", loc + 1)

        for k in range(index, loc, -1):
            CA[:, k] = CA[:, k - 1]
        CA[:, loc] = AA[:, index]
        print("CA Swap", index + 1)
        print(CA)

        temp = AA[:, index].copy()
        for m in range(index, loc, -1):
            AA[:, m] = AA[:, m - 1]
        AA[:, loc] = temp
        print("AA Swap", index + 1)
        print(AA)

    CA_ordered_row = np.zeros((no_of_attr, no_of_attr), dtype=int)
    n = 0
    for m in range(no_of_attr):
        order = CA[0, :]
        CA_ordered_row[n, :] = CA[int(order[m]), :]
        n += 1
    CA[1:][:] = CA_ordered_row
    print("Final")
    print(CA)

    return CA


CA = bea()
print("CA =")
print(CA)
