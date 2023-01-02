/*
Example - 1
*/
void foo(int[] array)
{
    int sum = 0;     // -> 1
    int product = 1; // -> 1
    for (int i = 0; i < array.length; i++)
    {
        sum += array[i]; // -> N
    }
    for (int i = 0; i < array.length; i++)
    {
        product *= array[i]; // -> N
    }
    cout << sum << ", " << product; // -> 1
}
/* Time Complexity:  O(N + N) => O(2N) => O(N) */

/*
Example - 2
*/
void printPairs(int[] array)
{
    for (int i = 0; i < array.length; i++)  // -> N
    {
        for (int j = 0; j < array.length; j++) // -> N
        {
            cout << array[i] << ", " << array[j] << endl;
        }
    }
}
/* O(N * N) => O(N^2) */
