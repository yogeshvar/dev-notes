#include <iostream>

using namespace std;

enum myVariables
{
    A = 5,
    B,
    C
};

int main()
{
    myVariables value = B;

    cout << value << endl;
}