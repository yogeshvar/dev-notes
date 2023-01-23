class MyQueue:

    def __init__(self) -> None:
        self.stack = []

    def print(self):
        print(self.stack)
    
    def push(self, x:int) -> None:
        self.stack.append(x)
    
    def pop(self) -> int:
        if len(self.stack) == 0:
            return -1   
        else:
            return self.stack.pop(0)
    
    def peek(self) -> int:
        if self.empty():
            return -1
        return self.stack[0]
    
    def empty(self) -> bool:
        if len(self.stack) == 0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()