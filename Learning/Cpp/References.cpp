#include <iostream>

// pass value by reference.
void increment(int *value)
{
    (*value)++;
}

// reference value changed.
void increase(int &value)
{
    value++;
}

int main()
{
    int a = 5;
    int b = 3;
    increment(&a);
    increase(b);

    /*
    int &ref = a;
    ref = b;
    a = 5, b = 5

    int *ref = &a;
    *ref = 2;
    ref = &b;
    *ref = 1;
    a = 2, b = 1 
    */

    std::cout << b << std::endl;
    std::cout << a << std::endl;
}