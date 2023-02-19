class OrderedStream(object):

    def __init__(self, n):
        """
        :type n: int
        """
        self.stream = [None] * (n + 1)
        self.ptr = 1
        self.n = n
        

    def insert(self, idKey, value):
        ans = []
        self.stream[idKey] = value
        
        while self.ptr <= self.n and self.stream[self.ptr] is not None:
            ans.append(self.stream[self.ptr])
            self.ptr += 1
        return ans
        """
        :type idKey: int
        :type value: str
        :rtype: List[str]
        """
        


# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)