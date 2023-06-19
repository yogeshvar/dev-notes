# 1.8 Cracking the coding interview.
def stringRotation(s1, s2): 
    if len(s1) == len(s2) and len(s1) > 0:
        s1s1 = s1 + s1
        return s2 in s1s1
    return False

x = stringRotation('waterbottle', 'erbottlewat')