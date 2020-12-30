#include <iostream>

using namespace std;

template <typename T>
struct Node
{
    T data;
    Node *next;
};

class LinkedList
{
    Node<int> *head;

public:
    LinkedList()
    {
        head = NULL;
    }
    void prepend(int data);
    void print();
};

void LinkedList::prepend(int data)
{
    Node<int> *newHead = new Node<int>;
    newHead->data = data;
    newHead->next = head;
    head = newHead;
}

void LinkedList::print()
{
    while (head)
    {
        cout << ' ' << head->data;
        head = head->next;
    }
}

int main()
{
    LinkedList list;

    list.prepend(10);
    list.prepend(9);
    list.print();
}
