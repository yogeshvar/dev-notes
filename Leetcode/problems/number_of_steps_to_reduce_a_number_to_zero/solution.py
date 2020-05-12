class Solution(object):
    def numberOfSteps (self, num):
        n = 0
        while True:
            if num is 0:
                return n
                break
            else:
                if num % 2 is 0:
                    num = num / 2
                    n = 1 + n
                else:
                    num = num - 1
                    n = 1 + n
        