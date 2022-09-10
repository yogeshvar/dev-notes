"""
Problem: https://leetcode.com/problems/palindrome-number/ (Easy)
Result: 🎉
Follow up: Could you solve it without converting the integer to a string? (Check func_int)
"""


def func(x: int) -> bool: 
    rev = ''.join(reversed(str(x)))
    if (str(x) == rev):
        return True 
    return False

def func_int(x: int) -> bool: 
    org = x 
    rev = 0
    while (x != 0):
        rem = x % 10
        rev = rev * 10 + rem
        x = int(x / 10)
    if org == rev: 
        return True
    return False

print(func(-121))
print(func_int(-121))