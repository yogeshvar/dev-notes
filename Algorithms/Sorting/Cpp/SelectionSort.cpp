#include <iostream>
using namespace std;

int main()
{
    int array[] = {64, 25, 12, 22, 11};
    int size = sizeof(array) / sizeof(array[0]);
    // One by one array selection.
    for (int i = 0; i < size - 1; i++)
    {
        // Find the min element in unsorted array.
        int min_index = i;
        for (int j = i + 1; j < size; j++)
        {
            if (array[j] < array[min_index])
                min_index = j;
        }
        // swap the found min element with the first element.
        int temp = array[min_index];
        array[min_index] = array[i];
        array[i] = temp;
    }
    // print sorted array.
    for (int i = 0; i < size; i++)
    {
        cout << array[i] << " ";
    }
}