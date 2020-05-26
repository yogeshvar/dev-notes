def selection_sort(a):
    for i in range(len(a)):
        min_idx = i
        for j in range(i + 1, len(a)):
            if a[min_idx] > a[j]:
                min_idx = j
        a[i], a[min_idx] = a[min_idx], a[i]

    for i in range(len(a)):
        print("%d" % a[i]),
    print '\n'
    print 'Min', a[0],
    print 'Max', a[len(a) - 1]


