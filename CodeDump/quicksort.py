def quicksort(a):
    if len(a) < 2:
        return a
    else:
        p = a[0]
        less = [i for i in a[1:] if i <= p]
        great = [i for i in a[1:] if i > p]
        return quicksort(less) + [p] + quicksort(great)
