# sort stack with additional one temp stack

stack = [34, 3, 31, 98, 92, 23]

tempStack = []

while stack:
    temp = stack.pop()
    while tempStack and tempStack[-1] > temp:
        stack.append(tempStack.pop())
    tempStack.append(temp)

print(tempStack)