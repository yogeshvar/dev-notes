#include <iostream>

using namespace std;

void printNumber(int a)
{
    cout << "Printing " << a << endl;
}

void printNumber(float b)
{
    cout << "Printing " << b << endl;
}

int main()
{
    int a = 54;
    float b = 12.3412;
    printNumber(a);
    printNumber(b);
    return 0;
}