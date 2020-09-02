/**
 * Pointers -> Contains Memory Address value.
 * 
 **/
#include <iostream>

using namespace std;

int main()
{
    int a = 10;
    cout << "Memory Address  " << &a << endl;

    int *aPointer;
    aPointer = &a;
    cout << "Pointer points to " << aPointer << endl;
    cout << "Pointer contains " << *aPointer << endl;
}