n = 8
result = 0

if(n == 0):
    print('0')

for i in range(1, n+1):
    n = n - i
    result += 1
    if(n < 0):
        print(result + 1)
        break
    elif(n == 0):
        print(result)
        break
