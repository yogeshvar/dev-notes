/**
 * Pass by Value ->  Send the value copy
 * Pass by Reference -> Send the value address [Pros: Less Memory]
 * Using Reference -> Send the value copy without creating a new variable [Pros: No new memory created]
 **/
#include <iostream>

using namespace std;

void passByValue(int a);
void passByReference(int *b);
void usingReference(int &a);

int main()
{
    int a = 10;
    int b = 20;
    int c = 0;
    passByValue(a);
    passByReference(&b);
    usingReference(c);

    cout << "Value of a " << a << endl;
    cout << "Value of b " << b << endl;
    cout << "Value of cby reference " << c << endl;
}

void passByValue(int a)
{
    a = 50;
}

void passByReference(int *b)
{
    *b = 100;
}

void usingReference(int &c)
{
    c++;
}