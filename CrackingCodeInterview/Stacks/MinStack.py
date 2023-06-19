class MinStack:

    def __init__(self):
        self.items = []
        self.min = []

    def push(self, val: int) -> None:
        self.items.append(val)
        if not self.min or self.min[-1] >= val:
            self.min.append(val)

    def pop(self) -> None:
        if not self.items:
            return
        top = self.items.pop()
        if top == self.min[-1]:
            self.min.pop()
        return top

    def top(self) -> int:
        return self.items[len(self.items) - 1]

    def getMin(self) -> int:
        return self.min[-1]
