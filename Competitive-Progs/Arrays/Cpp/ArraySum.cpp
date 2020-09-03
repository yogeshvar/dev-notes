#include <iostream>
using namespace std;

int main()
{
    int size = 6;
    int result = 0;
    int arr[] = {1, 2, 3, 4, 10, 11};

    for (int i = 0; i < size; i++)
    {
        result += arr[i];
    }
    cout << result << endl;

    return 0;
}