# array intersection
a = [1, 2, 3, 4, 5]
b = [2, 1, 5, 3, 4]


c = [index for index, (e1, e2) in enumerate(zip(a, b)) if e1 != e2]
print(c)
