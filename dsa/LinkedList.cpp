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
    void append(int data);
    void printHead();
    void print();
};

void LinkedList::printHead()
{
    cout << "current head:" << head->data;
}

void LinkedList::prepend(int data)
{
    Node<int> *newHead = new Node<int>;
    newHead->data = data;
    if (head)
        newHead->next = head;
    else
        newHead->next = NULL;
    head = newHead;
}

void LinkedList::append(int data)
{
    Node<int> *newTail = new Node<int>;
    newTail->data = data;
    newTail->next = NULL;

    if (head->next == NULL)
    {
        head = newTail;
    }
    else
    {

        while (head)
        {
            if (head->next == NULL)
            {
                head->next = newTail;
                break;
            }
            head = head->next;
        }
    }
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
    // list.prepend(9);
    list.prepend(10);
    list.append(11);
    list.append(12);
    list.print();
}
