s = 'abcac'
n = 10

"""
Not a good solution. Runtime error cause it's too long.
"""


def repeatedString(s, n):
    repeated_string = s
    if s == 'a':
        return n
    while len(repeated_string) < n:
        if (len(repeated_string) + len(s)) < n:
            repeated_string += s
        else:
            remaining_len = n % (len(repeated_string))
            repeated_string += s[0:remaining_len]
    count = 0
    print(repeated_string)
    for i in repeated_string:
        if i == 'a':
            count += 1
    return count


def repeatedString2(s, n):
    count = 0
    for i in range(n):
        if s[i % len(s)] == 'a':
            count += 1
    return count


def repeatedString3(s, n):
    return s.count('a') * (n // len(s)) + s[:n % len(s)].count('a')


ans2 = repeatedString2(s, n)
ans3 = repeatedString3(s, n)
print(ans2)
print(ans3)
