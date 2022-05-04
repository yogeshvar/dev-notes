#include <iostream>
using namespace std;

int main()
{
    int rows = 4;
    for (int i = 0; i <= rows; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "*";
        }
        cout << "\n";
    }
}