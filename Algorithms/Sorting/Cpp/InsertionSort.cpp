#include <iostream>
using namespace std;

int main()
{
    int array[] = {12, 11, 13, 5, 6};
    int size = sizeof(array) / sizeof(array[0]);
    int i, key, j;
    for (int i = 1; i < size; i++)
    {
        // choose the key element.
        key = array[i];
        j = i - 1;
        // check if the key element is greater.
        while (j >= 0 && array[j] > key)
        {
            // swap the smallest element.
            array[j + 1] = array[j];
            j = j - 1;
        }
        // set the key element.  
        array[j + 1] = key;
    }

    for (int i = 0; i < size; i++)
    {
        cout << array[i] << " ";
    }
}
