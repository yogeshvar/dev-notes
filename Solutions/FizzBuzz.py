for i in range(0,15,1):
    if (i+1) % 3 is 0 and (i+1) % 5 is 0:
        print('FizzBuzz')
    elif (i + 1) % 3 is 0:
        print('Fizz')
    elif (i + 1) % 5 is 0:
        print('Buzz')
    else:
        print(i+1)