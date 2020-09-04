#include <iostream>

using namespace std;

template <typename T>
void Print(T value)
{
    cout << value << endl;
}

int main()
{
    Print(5);
    Print("Hello");
    Print(5.5f);
}