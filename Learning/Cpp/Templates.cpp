#include <iostream>

using namespace std;

template <typename T>
void Print(T value)
{
    cout << value << endl;
}

template <typename T, int N>
class Array
{
private:
    T m_Array[N];

public:
    int getSize() const { return N; }
};

int main()
{
    Print<string>("Hello");
    Print<float>(5.5f);
    Print<int>(5);

    Array<int, 5> array;
    cout << array.getSize() << endl;
}