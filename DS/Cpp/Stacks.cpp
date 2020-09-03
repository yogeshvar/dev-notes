#include <iostream>

using namespace std;

class Stack
{
    int top;

public:
    int a[100];
    Stack()
    {
        top = -1;
    }
    bool push(int x);
    int pop();
    int peek();
    bool isEmpty();
};

bool Stack::push(int x)
{
    if (top >= (100 - 1))
    {
        cout << "Overflow";
        return false;
    }
    else
    {
        a[++top] = x;
        cout << x << " pushed to stack" << endl;
        return true;
    }
}

int Stack::pop()
{
    if (top < 0)
    {
        cout << "No Elements to Pop";
        return 0;
    }
    else
    {
        return a[top--];
    }
}

int Stack::peek()
{
    if (top < 0)
    {
        cout << "No elements to Peek";
        return 0;
    }
    else
    {
        return a[top];
    }
}

bool Stack::isEmpty()
{
    return (top < 0);
}

int main()
{
    Stack stack;
    cout << "Is Empty ? " << stack.isEmpty() << endl;
    stack.push(1);
    stack.push(2);
    stack.push(3);
    cout << "Peek Value " << stack.peek() << endl;
    cout << "Pop Value " << stack.pop() << endl;
    stack.push(4);
    cout << "Peek Value " << stack.peek() << endl;
}
