#include <iostream>
using namespace std;

int main()
{
    int array[] = {64, 25, 12, 22, 11};
    int size = sizeof(array) / sizeof(array[0]);
    int find = 12;
    int low = 0;
    int high = size - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (array[mid] == find)
        {
            cout << mid << " ";
            break;
        }
        else if (array[mid] < find)
            low = mid + 1;
        else
            high = mid - 1;
    }
}