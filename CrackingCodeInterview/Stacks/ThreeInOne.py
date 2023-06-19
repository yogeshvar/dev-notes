# three in one stack implementation using a single list

class MultiStack:
    def __init__(self, stack_size):
        self.stack_size = stack_size
        self.stack = [None] * stack_size * 3
        self.stack_pointers = [0, 0, 0]

    def push(self, stack_num, value):
        if self.stack_pointers[stack_num] == self.stack_size:
            raise Exception("Stack is full")
        self.stack[self.stack_pointers[stack_num] +
                   stack_num * self.stack_size] = value
        self.stack_pointers[stack_num] += 1

    def pop(self, stack_num):
        if self.stack_pointers[stack_num] == 0:
            raise Exception("Stack is empty")
        self.stack_pointers[stack_num] -= 1
        return self.stack[self.stack_pointers[stack_num] + stack_num * self.stack_size]

    def peek(self, stack_num):
        if self.stack_pointers[stack_num] == 0:
            raise Exception("Stack is empty")
        return self.stack[self.stack_pointers[stack_num] - 1 + stack_num * self.stack_size]

    def is_empty(self, stack_num):
        return self.stack_pointers[stack_num] == 0

    def is_full(self, stack_num):
        return self.stack_pointers[stack_num] == self.stack_size
