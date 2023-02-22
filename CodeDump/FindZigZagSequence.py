a = [1, 2, 3, 4, 5, 6, 7]
n = 7

a.sort()
mid = int((7)/2)
a[mid], a[n-1] = a[n-1], a[mid]

st = mid + 1
ed = n - 2
while (st <= ed):
    a[st], a[ed] = a[ed], a[st]
    st += 1
    ed -= 1
