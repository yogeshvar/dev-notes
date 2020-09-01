# find pair of socks
n = 15
ar = [6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5]
res = 0
ar.sort()

unique_values = list(set(ar))
unique_values.sort()

for i in unique_values:
    if ar.count(i) % 2 is 0:
        res = res + ar.count(i) // 2
    elif ar.count(i) % 2 is not 0:
        if ar.count(i) is 1:
            pass
        else:
            res = res + ar.count(i) // 2
print res


