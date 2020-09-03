/**
 * Pass by Value ->  Send the value copy
 * Pass by Reference -> Send the value address [Pros: Less Memory]
 **/
#include <iostream>

using namespace std;

void passByValue(int a);
void passByReference(int *b);

int main()
{
    int a = 10;
    int b = 20;
    passByValue(a);
    passByReference(&b);

    cout << "Value of a " << a << endl;
    cout << "Value of b " << b << endl;
}

void passByValue(int a)
{
    a = 50;
}

void passByReference(int *b)
{
    *b = 100;
}