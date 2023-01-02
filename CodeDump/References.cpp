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

    std::cout << b << std::endl;
    std::cout << a << std::endl;
}